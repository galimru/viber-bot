package com.viber.bot.listeners;

import com.viber.bot.events.IncomingConversationStartedEvent;
import com.viber.bot.server.ServerResponse;

public interface OnConversationStartedListener extends EventListener {
    void handle(IncomingConversationStartedEvent event, ServerResponse response);
}
