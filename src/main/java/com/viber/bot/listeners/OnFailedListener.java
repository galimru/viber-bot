package com.viber.bot.listeners;

import com.viber.bot.events.IncomingFailedEvent;
import com.viber.bot.server.ServerResponse;

public interface OnFailedListener extends EventListener {
    void handle(IncomingFailedEvent event, ServerResponse response);
}
