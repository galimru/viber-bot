package com.viber.bot.listeners;

import com.viber.bot.events.IncomingWebhookEvent;
import org.glassfish.grizzly.http.server.Response;

public interface OnWebhookListener extends EventListener {
    void handle(IncomingWebhookEvent event, Response response);
}
