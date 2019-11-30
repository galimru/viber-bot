package com.viber.bot.listeners;

import com.viber.bot.events.IncomingDeliveredEvent;
import com.viber.bot.server.ServerResponse;

public interface OnDeliveredListener extends EventListener {
    void handle(IncomingDeliveredEvent event, ServerResponse response);
}
