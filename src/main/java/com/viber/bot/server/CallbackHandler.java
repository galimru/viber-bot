package com.viber.bot.server;

import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import java.io.IOException;

public interface CallbackHandler {
    void handle(Request request, Response response) throws IOException;
}
