package com.viber.bot.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.messages.Profile;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingConversationStartedEvent extends IncomingEvent {

    @JsonProperty(value = "type")
    protected String type;

    @JsonProperty(value = "context")
    protected String context;

    @JsonProperty(value = "user")
    protected Profile user;

    @JsonProperty(value = "subscribed")
    protected Boolean subscribed;

    public String getType() {
        return type;
    }

    public IncomingConversationStartedEvent setType(String type) {
        this.type = type;
        return this;
    }

    public String getContext() {
        return context;
    }

    public IncomingConversationStartedEvent setContext(String context) {
        this.context = context;
        return this;
    }

    public Profile getUser() {
        return user;
    }

    public IncomingConversationStartedEvent setUser(Profile user) {
        this.user = user;
        return this;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public IncomingConversationStartedEvent setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
        return this;
    }
}
