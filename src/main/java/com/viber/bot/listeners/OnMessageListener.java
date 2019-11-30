package com.viber.bot.listeners;

import com.viber.bot.events.IncomingMessageEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnMessageListener extends EventListener {
    void handle(IncomingMessageEvent event, Response response);
}
