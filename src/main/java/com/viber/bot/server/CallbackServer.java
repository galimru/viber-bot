package com.viber.bot.server;

import com.google.common.base.Preconditions;
import org.glassfish.grizzly.http.server.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CallbackServer {

    private final static String SERVER_NAME = "grizzly";

    private Logger logger = LoggerFactory.getLogger(CallbackServer.class);

    private HttpServer httpServer;

    public CallbackServer() {
        this.httpServer = new HttpServer();
    }

    public void addCallbackHandler(String path, CallbackHandler handler) {
        Preconditions.checkNotNull(path, "path is null");
        Preconditions.checkNotNull(handler, "handler is null");

        ServerConfiguration configuration = httpServer.getServerConfiguration();
        configuration.addHttpHandler(new HttpHandler() {
            @Override
            public void service(Request request, Response response) throws Exception {
                handler.handle(request, response);
            }
        }, path);
    }

    public void listen(String host, int port) throws IOException {
        NetworkListener networkListener = new NetworkListener(SERVER_NAME, host, port);
        httpServer.addListener(networkListener);
        httpServer.start();
        logger.info("Listening address {}:{} for callback requests", host, port);
    }

    public void shutdown() {
        httpServer.shutdown();
        logger.info("Callback server shutdown");
    }
}
