package com.viber.bot.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.messages.Message;
import com.viber.bot.messages.Profile;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingMessageEvent extends IncomingEvent {

    @JsonProperty(value = "sender")
    protected Profile sender;

    @JsonProperty(value = "message")
    protected Message message;

    public Profile getSender() {
        return sender;
    }

    public IncomingMessageEvent setSender(Profile sender) {
        this.sender = sender;
        return this;
    }

    public Message getMessage() {
        return message;
    }

    public IncomingMessageEvent setMessage(Message message) {
        this.message = message;
        return this;
    }
}
