package com.viber.bot.message;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TextVAlign {
    MIDDLE("middle");

    private String value;

    TextVAlign(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
