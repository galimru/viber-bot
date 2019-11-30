package com.viber.bot.message;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessage.class, name = "text"),
        @JsonSubTypes.Type(value = ContactMessage.class, name = "contact"),
})
public abstract class Message {

    @JsonProperty(value = "type")
    protected MessageType type;

    @JsonProperty(value = "receiver")
    protected String receiver;

    @JsonProperty(value = "min_api_version")
    protected Integer minApiVersion;

    @JsonProperty(value = "sender")
    protected Profile sender;

    @JsonProperty(value = "trackingData")
    protected String trackingData;

    @JsonProperty(value = "keyboard")
    protected Keyboard keyboard;

    protected Map<String, Object> customProperties = new HashMap<>();

    public Message(MessageType type) {
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getMinApiVersion() {
        return minApiVersion;
    }

    public void setMinApiVersion(Integer minApiVersion) {
        this.minApiVersion = minApiVersion;
    }

    public Profile getSender() {
        return sender;
    }

    public void setSender(Profile sender) {
        this.sender = sender;
    }

    public String getTrackingData() {
        return trackingData;
    }

    public void setTrackingData(String trackingData) {
        this.trackingData = trackingData;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @JsonAnyGetter
    public Map<String, Object> getCustomProperties() {
        return customProperties;
    }
}
