package com.viber.bot.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.viber.bot.ViberBot;
import com.viber.bot.events.IncomingEvent;
import org.glassfish.grizzly.http.Method;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DefaultHandler implements CallbackHandler {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(DefaultHandler.class);

    private ViberBot viberBot;

    public DefaultHandler(ViberBot viberBot) {
        this.viberBot = viberBot;
    }

    @Override
    public void handle(Request request, Response response) throws IOException {
        if (request.getMethod() == Method.POST) {
            String signature = request.getHeader(ViberBot.SIGNATURE_HEADER);
            String content = CharStreams.toString(request.getReader());
            if (!viberBot.validateJson(signature, content)) {
                logger.warn("Signature validation failed: signature {}, content {}", signature, content);
                response.sendError(HttpStatus.UNAUTHORIZED_401.getStatusCode());
                return;
            }
            IncomingEvent incomingEvent = OBJECT_MAPPER.readValue(content, IncomingEvent.class);
            viberBot.handle(incomingEvent, response);
        } else {
            response.sendError(HttpStatus.METHOD_NOT_ALLOWED_405.getStatusCode());
        }
    }
}
