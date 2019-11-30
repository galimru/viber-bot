package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ScaleType {
    CROP("crop"),
    FILL("fill"),
    FIT("fit");

    private String value;

    ScaleType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
