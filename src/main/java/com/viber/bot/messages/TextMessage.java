package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextMessage extends Message {

    @JsonProperty(value = "text")
    protected String text;

    public TextMessage() {
        super(MessageType.TEXT);
    }

    public TextMessage(String text) {
        super(MessageType.TEXT);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public TextMessage setText(String text) {
        this.text = text;
        return this;
    }
}
