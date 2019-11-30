package com.viber.bot.message;

public enum TextHAlign {
    LEFT("left"),
    RIGHT("right");

    private String value;

    TextHAlign(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
