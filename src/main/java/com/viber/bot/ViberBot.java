package com.viber.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import com.viber.bot.api.*;
import com.viber.bot.event.EventListener;
import com.viber.bot.event.EventType;
import com.viber.bot.event.IncomingEvent;
import com.viber.bot.message.Message;
import com.viber.bot.message.Profile;
import com.viber.bot.server.CallbackServer;
import com.viber.bot.server.DefaultHandler;
import com.viber.bot.util.SignatureValidator;
import okhttp3.*;

import java.io.IOException;
import java.util.*;

public class ViberBot {

    public final static String SIGNATURE_HEADER = "X-Viber-Content-Signature";
    private final static String API_URL = "https://chatapi.viber.com/pa";
    private final static String AUTH_TOKEN_HEADER = "X-Viber-Auth-Token";
    private final static String USER_AGENT = "ViberBot/2.0.0";
    private final static String CONTENT_TYPE = "application/json; charset=utf-8";
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Profile profile;
    private String token;
    private OkHttpClient httpClient;
    private CallbackServer callbackServer;
    private SignatureValidator signatureValidator;

    private Map<EventType, Collection<EventListener>> eventListeners = new HashMap<>();

    public ViberBot(String name, String token) {
        this.profile = new Profile(name);
        this.token = token;
        this.httpClient = new OkHttpClient();
        this.callbackServer = new CallbackServer();
        this.signatureValidator = new SignatureValidator(token);
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void addEventListener(EventType type, EventListener listener) {
        Collection<EventListener> listeners = eventListeners.getOrDefault(type, new ArrayList<>());
        listeners.add(listener);
        eventListeners.put(type, listeners);
    }

    public void removeEventListener(EventListener listener) {
        eventListeners.values().stream()
                .filter(listeners -> listeners.contains(listener))
                .forEach(listeners -> listeners.remove(listener));
    }

    public void removeEventListeners(EventType type) {
        eventListeners.remove(type);
    }

    public ApiResponse setWebhook(String url) {
        return executeRequest(Endpoint.SET_WEBHOOK, new SetWebhook()
                .setUrl(url), ApiResponse.class);
    }

    public ApiResponse setWebhook(String url, EventType... eventTypes) {
        return executeRequest(Endpoint.SET_WEBHOOK, new SetWebhook()
                .setUrl(url)
                .setEventTypes(Arrays.asList(eventTypes)), ApiResponse.class);
    }

    public void handle(IncomingEvent event) {
        Collection<EventListener> listeners = eventListeners.get(event.getEvent());
        if (listeners != null) {
            listeners.forEach(listener -> listener.handle(event));
        }
    }

    public void listen(String host, int port, String path) throws IOException {
        callbackServer.addCallbackHandler(path, new DefaultHandler(this));
        callbackServer.listen(host, port);
    }

    public AccountInfo getAccountInfo() {
        return executeRequest(Endpoint.GET_ACCOUNT_INFO,
                new HashMap<>(), AccountInfo.class);
    }

    public UserDetails getUserDetails(String userId) {
        return executeRequest(Endpoint.GET_USER_DETAILS,
                ImmutableMap.of("id", userId), UserDetails.class);
    }

    public OnlineStatus getOnlineStatus(Collection<String> userIds) {
        return executeRequest(Endpoint.GET_ONLINE_STATUS,
                ImmutableMap.of("ids", userIds), OnlineStatus.class);
    }

    public ApiResponse sendMessage(String userId, Message message) {
        message.setReceiver(userId);
        message.setSender(profile);
        return executeRequest(Endpoint.SEND_MESSAGE, message, ApiResponse.class);
    }

    public boolean validateJson(String signature, String json) {
        return signatureValidator.validate(signature, json);
    }

    private <T extends ApiResponse> T executeRequest(Endpoint endpoint, Object payload, Class<T> responseClass)
            throws ApiException {
        String content;
        try {
            content = OBJECT_MAPPER.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new ApiException(String.format("Cannot deserialize request payload: %s", payload), e);
        }
        String response;
        try {
            Response httpResponse = httpClient.newCall(new Request.Builder()
                    .url(API_URL + endpoint.getPath())
                    .addHeader(AUTH_TOKEN_HEADER, token)
                    .addHeader(HttpHeaders.USER_AGENT, USER_AGENT)
                    .post(RequestBody.create(content, MediaType.parse(CONTENT_TYPE)))
                    .build()).execute();
            response = httpResponse.body().string();
        } catch (IOException e) {
            throw new ApiException(String.format("Cannot execute request %s with payload %s", endpoint, payload), e);
        }
        try {
            T apiResponse = OBJECT_MAPPER.readValue(response, responseClass);
            if (apiResponse.getStatus() != 0) {
                throw new ApiException(apiResponse.getStatusMessage());
            }
            return apiResponse;
        } catch (IOException e) {
            throw new ApiException(String.format("Cannot serialize response payload: %s", response));
        }
    }

}
