package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MediaType {
    PICTURE("picture"),
    GIF("gif");

    private String value;

    MediaType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
