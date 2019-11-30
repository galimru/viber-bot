package com.viber.bot.listeners;

import com.viber.bot.events.IncomingConversationStartedEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnConversationStartedListener extends EventListener {
    void handle(IncomingConversationStartedEvent event, Response response);
}
