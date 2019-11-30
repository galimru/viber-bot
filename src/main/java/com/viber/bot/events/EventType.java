package com.viber.bot.events;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EventType {
    MESSAGE("message"),
    DELIVERED("delivered"),
    SEEN("seen"),
    FAILED("failed"),
    SUBSCRIBED("subscribed"),
    UNSUBSCRIBED("unsubscribed"),
    CONVERSATION_STARTED("conversation_started"),
    WEBHOOK("webhook"),
    ACTION("action"),;

    private String value;

    EventType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
