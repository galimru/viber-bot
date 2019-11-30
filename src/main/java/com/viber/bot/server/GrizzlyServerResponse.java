package com.viber.bot.server;

import org.glassfish.grizzly.http.server.Response;

import java.io.IOException;
import java.io.Writer;

public class GrizzlyServerResponse implements ServerResponse {

    protected Response delegate;

    public GrizzlyServerResponse(Response delegate) {
        this.delegate = delegate;
    }

    public Writer getWriter() {
        return delegate.getWriter();
    }

    public void sendError(int status) throws IOException {
        delegate.sendError(status);
    }

    public void sendRedirect(String location) throws IOException {
        delegate.sendRedirect(location);
    }
}
