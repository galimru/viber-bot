package com.viber.bot.events;

import com.fasterxml.jackson.annotation.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        visible = true,
        property = "event")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IncomingMessageEvent.class, name = "message"),
        @JsonSubTypes.Type(value = IncomingDeliveredEvent.class, name = "delivered"),
        @JsonSubTypes.Type(value = IncomingSeenEvent.class, name = "seen"),
        @JsonSubTypes.Type(value = IncomingSubscribedEvent.class, name = "subscribed"),
        @JsonSubTypes.Type(value = IncomingUnsubscribedEvent.class, name = "unsubscribed"),
        @JsonSubTypes.Type(value = IncomingConversationStartedEvent.class, name = "conversation_started"),
        @JsonSubTypes.Type(value = IncomingWebhookEvent.class, name = "webhook"),
})
public class IncomingEvent {

    @JsonProperty(value = "event")
    protected EventType event;

    @JsonProperty(value = "timestamp")
    protected Long timestamp;

    @JsonProperty(value = "message_token")
    protected String messageToken;

    @JsonProperty(value = "chat_hostname")
    protected String chatHostname;

    public EventType getEvent() {
        return event;
    }

    public IncomingEvent setEvent(EventType event) {
        this.event = event;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public IncomingEvent setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessageToken() {
        return messageToken;
    }

    public IncomingEvent setMessageToken(String messageToken) {
        this.messageToken = messageToken;
        return this;
    }

    public String getChatHostname() {
        return chatHostname;
    }

    public IncomingEvent setChatHostname(String chatHostname) {
        this.chatHostname = chatHostname;
        return this;
    }
}
