package com.viber.bot.listeners;

import com.viber.bot.events.IncomingUnsubscribedEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnUnsubscribedListener extends EventListener {
    void handle(IncomingUnsubscribedEvent event, Response response);
}
