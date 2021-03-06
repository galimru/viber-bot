package com.viber.bot.listeners;

import com.viber.bot.events.IncomingSubscribedEvent;
import com.viber.bot.server.ServerResponse;

public interface OnSubscribedListener extends EventListener {
    void handle(IncomingSubscribedEvent event, ServerResponse response);
}
