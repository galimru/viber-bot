package com.viber.bot.messages;

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
        @JsonSubTypes.Type(value = PictureMessage.class, name = "picture"),
        @JsonSubTypes.Type(value = VideoMessage.class, name = "video"),
        @JsonSubTypes.Type(value = FileMessage.class, name = "file"),
        @JsonSubTypes.Type(value = ContactMessage.class, name = "contact"),
        @JsonSubTypes.Type(value = LocationMessage.class, name = "location"),
        @JsonSubTypes.Type(value = UrlMessage.class, name = "url"),
        @JsonSubTypes.Type(value = StickerMessage.class, name = "sticker"),
        @JsonSubTypes.Type(value = RichMediaMessage.class, name = "rich_media"),
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

    public Message setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public Integer getMinApiVersion() {
        return minApiVersion;
    }

    public Message setMinApiVersion(Integer minApiVersion) {
        this.minApiVersion = minApiVersion;
        return this;
    }

    public Profile getSender() {
        return sender;
    }

    public Message setSender(Profile sender) {
        this.sender = sender;
        return this;
    }

    public String getTrackingData() {
        return trackingData;
    }

    public Message setTrackingData(String trackingData) {
        this.trackingData = trackingData;
        return this;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Message setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getCustomProperties() {
        return customProperties;
    }
}
