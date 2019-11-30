package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyboardMessage extends Message {

    @JsonProperty(value = "keyboard")
    protected Keyboard keyboard;

    public KeyboardMessage() {
        super(MessageType.KEYBOARD);
    }

    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }

    @Override
    public KeyboardMessage setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        return this;
    }
}
