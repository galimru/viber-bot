package com.viber.bot.listeners;

import com.viber.bot.events.IncomingSeenEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnSeenListener extends EventListener {
    void handle(IncomingSeenEvent event, Response response);
}
