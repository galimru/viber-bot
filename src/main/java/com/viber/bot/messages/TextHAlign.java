package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TextHAlign {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right");

    private String value;

    TextHAlign(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
