package com.viber.bot.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.messages.Profile;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingSubscribedEvent extends IncomingEvent {

    @JsonProperty(value = "user")
    protected Profile user;

    public Profile getUser() {
        return user;
    }

    public IncomingSubscribedEvent setUser(Profile user) {
        this.user = user;
        return this;
    }
}
