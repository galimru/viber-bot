package com.viber.bot.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.message.Message;
import com.viber.bot.message.Profile;


@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingEvent {

    @JsonProperty(value = "event")
    protected EventType event;

    @JsonProperty(value = "timestamp")
    protected Long timestamp;

    @JsonProperty(value = "chat_hostname")
    protected String chatHostname;

    @JsonProperty(value = "message_token")
    protected String messageToken;

    @JsonProperty(value = "sender")
    protected Profile sender;

    @JsonProperty(value = "message")
    protected Message message;

    public EventType getEvent() {
        return event;
    }

    public void setEvent(EventType event) {
        this.event = event;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getChatHostname() {
        return chatHostname;
    }

    public void setChatHostname(String chatHostname) {
        this.chatHostname = chatHostname;
    }

    public String getMessageToken() {
        return messageToken;
    }

    public void setMessageToken(String messageToken) {
        this.messageToken = messageToken;
    }

    public Profile getSender() {
        return sender;
    }

    public void setSender(Profile sender) {
        this.sender = sender;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
