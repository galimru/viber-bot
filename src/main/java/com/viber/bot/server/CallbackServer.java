package com.viber.bot.server;

import com.google.common.base.Preconditions;
import org.glassfish.grizzly.http.server.*;

import java.io.IOException;

public class CallbackServer {

    private final static String SERVER_NAME = "grizzly";
    private final static String DEFAULT_HOST = "localhost";
    private final static int DEFAULT_PORT = 80;

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
        listen(null, null);
    }

    public void listen(String host, Integer port) throws IOException {
        if (host == null) {
            host = DEFAULT_HOST;
        }
        if (port == null) {
            port = DEFAULT_PORT;
        }
        NetworkListener networkListener = new NetworkListener(SERVER_NAME, host, port);
        httpServer.addListener(networkListener);
        httpServer.start();
    }

    public void shutdown() {
        httpServer.shutdown();
    }
}
