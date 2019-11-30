package com.viber.bot.message;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
    REPLY("reply");

    private String value;

    ActionType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
