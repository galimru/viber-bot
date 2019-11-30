package com.viber.bot.listeners;

import com.viber.bot.events.IncomingDeliveredEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnDeliveredListener extends EventListener {
    void handle(IncomingDeliveredEvent event, Response response);
}
