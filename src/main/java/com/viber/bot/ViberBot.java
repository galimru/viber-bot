package com.viber.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import com.viber.bot.api.*;
import com.viber.bot.events.*;
import com.viber.bot.listeners.*;
import com.viber.bot.listeners.EventListener;
import com.viber.bot.messages.Message;
import com.viber.bot.messages.Profile;
import com.viber.bot.server.CallbackServer;
import com.viber.bot.server.DefaultHandler;
import com.viber.bot.server.ServerResponse;
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

    private Set<EventListener> eventListeners = new HashSet<>();

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

    public void addMessageListener(OnMessageListener listener) {
        addEventListener(listener);
    }

    public void addDeliveredListener(OnDeliveredListener listener) {
        addEventListener(listener);
    }

    public void addSeenListener(OnSeenListener listener) {
        addEventListener(listener);
    }

    public void addSubscribedListener(OnSubscribedListener listener) {
        addEventListener(listener);
    }

    public void addUnsubscribedListener(OnUnsubscribedListener listener) {
        addEventListener(listener);
    }

    public void addConversationStartedListener(OnConversationStartedListener listener) {
        addEventListener(listener);
    }

    public void addWebhookListener(OnWebhookListener listener) {
        addEventListener(listener);
    }

    public void addFailedListener(OnFailedListener listener) {
        addEventListener(listener);
    }

    protected void addEventListener(EventListener listener) {
        eventListeners.add(listener);
    }

    public void removeEventListener(EventListener listener) {
        eventListeners.remove(listener);
    }

    public void handle(IncomingEvent event) {
        handle(event, null);
    }

    public void handle(IncomingEvent event, ServerResponse response) {
        eventListeners.forEach(listener -> {
            if (listener instanceof OnMessageListener) {
                ((OnMessageListener) listener).handle((IncomingMessageEvent) event, response);
            } else if (listener instanceof OnDeliveredListener) {
                ((OnDeliveredListener) listener).handle((IncomingDeliveredEvent) event, response);
            } else if (listener instanceof OnSeenListener) {
                ((OnSeenListener) listener).handle((IncomingSeenEvent) event, response);
            } else if (listener instanceof OnSubscribedListener) {
                ((OnSubscribedListener) listener).handle((IncomingSubscribedEvent) event, response);
            } else if (listener instanceof OnUnsubscribedListener) {
                ((OnUnsubscribedListener) listener).handle((IncomingUnsubscribedEvent) event, response);
            } else if (listener instanceof OnConversationStartedListener) {
                ((OnConversationStartedListener) listener).handle((IncomingConversationStartedEvent) event, response);
            } else if (listener instanceof OnWebhookListener) {
                ((OnWebhookListener) listener).handle((IncomingWebhookEvent) event, response);
            } else if (listener instanceof OnFailedListener) {
                ((OnFailedListener) listener).handle((IncomingFailedEvent) event, response);
            }
        });
    }

    public void listen(String host, Integer port, String path) throws IOException {
        callbackServer.addCallbackHandler(path, new DefaultHandler(this));
        callbackServer.listen(host, port);
    }

    public void listen(String path) throws IOException {
        listen(null, null, path);
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

    public AccountInfo getAccountInfo() {
        return executeRequest(Endpoint.GET_ACCOUNT_INFO,
                new HashMap<>(), AccountInfo.class);
    }

    public UserDetails getUserDetails(String userId) {
        return executeRequest(Endpoint.GET_USER_DETAILS,
                ImmutableMap.of("id", userId), UserDetails.class);
    }

    public OnlineStatus getOnlineStatus(String... userIds) {
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
                    .post(RequestBody.create(MediaType.parse(CONTENT_TYPE), content))
                    .build()).execute();
            ResponseBody body = httpResponse.body();
            if (body == null) {
                throw new ApiException("Cannot get body content from cached request");
            }
            response = body.string();
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
