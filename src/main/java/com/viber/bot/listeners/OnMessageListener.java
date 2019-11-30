package com.viber.bot.listeners;

import com.viber.bot.events.IncomingMessageEvent;
import com.viber.bot.server.ServerResponse;

public interface OnMessageListener extends EventListener {
    void handle(IncomingMessageEvent event, ServerResponse response);
}
