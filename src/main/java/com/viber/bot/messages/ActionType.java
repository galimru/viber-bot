package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
    REPLY("reply"),
    OPEN_URL("open-url"),
    LOCATION_PICKER("location-picker"),
    SHARE_PHONE("share-phone"),
    NONE("none");

    private String value;

    ActionType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
