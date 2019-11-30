package com.viber.bot.listeners;

import com.viber.bot.events.IncomingFailedEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnFailedListener extends EventListener {
    void handle(IncomingFailedEvent event, Response response);
}
