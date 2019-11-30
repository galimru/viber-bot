package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InputFieldState {
    REGULAR("regular"),
    MINIMIZED("minimized"),
    HIDDEN("hidden");

    private String value;

    InputFieldState(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
