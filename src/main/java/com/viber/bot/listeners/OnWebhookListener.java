package com.viber.bot.listeners;

import com.viber.bot.events.IncomingWebhookEvent;
import com.viber.bot.server.ServerResponse;

public interface OnWebhookListener extends EventListener {
    void handle(IncomingWebhookEvent event, ServerResponse response);
}
