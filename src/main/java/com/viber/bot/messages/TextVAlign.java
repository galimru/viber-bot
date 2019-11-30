package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TextVAlign {
    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom");

    private String value;

    TextVAlign(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
