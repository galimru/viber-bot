package com.viber.bot.message;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageType {
    TEXT("text"),
    PICTURE("picture"),
    VIDEO("video"),
    FILE("file"),
    CONTACT("contact"),
    LOCATION("location"),
    URL("url"),
    STICKER("sticker"),
    RICH_MEDIA("rich_media"),
    KEYBOARD("keyboard");

    private String value;

    MessageType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
