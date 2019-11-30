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
                try {
                    handler.handle(request, response);
                } catch (Exception e) {
                    logger.error(String.format("An error occurred while handling request for path %s", path), e);
                }
            }
        }, path);
    }

    public void listen(String host, Integer port) throws IOException {
        if (host == null) {
            host = NetworkListener.DEFAULT_NETWORK_HOST;
        }
        if (port == null) {
            port = NetworkListener.DEFAULT_NETWORK_PORT;
        }
        NetworkListener networkListener = new NetworkListener(SERVER_NAME, host, port);
        httpServer.addListener(networkListener);
        httpServer.start();
    }

    public void shutdown() {
        httpServer.shutdown();
    }
}
