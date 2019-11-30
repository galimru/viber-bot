package com.viber.bot.message;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TextSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private String value;

    TextSize(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
