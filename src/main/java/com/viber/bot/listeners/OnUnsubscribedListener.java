package com.viber.bot.listeners;

import com.viber.bot.events.IncomingUnsubscribedEvent;
import com.viber.bot.server.ServerResponse;

public interface OnUnsubscribedListener extends EventListener {
    void handle(IncomingUnsubscribedEvent event, ServerResponse response);
}
