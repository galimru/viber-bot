package com.viber.bot.listeners;

import com.viber.bot.events.IncomingSubscribedEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnSubscribedListener extends EventListener {
    void handle(IncomingSubscribedEvent event, Response response);
}
