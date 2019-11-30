package com.viber.bot.listeners;

import com.viber.bot.events.IncomingSeenEvent;
import com.viber.bot.server.ServerResponse;

public interface OnSeenListener extends EventListener {
    void handle(IncomingSeenEvent event, ServerResponse response);
}
