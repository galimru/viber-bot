package com.viber.bot.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingSeenEvent extends IncomingEvent {

    @JsonProperty(value = "user_id")
    protected String userId;

    public String getUserId() {
        return userId;
    }

    public IncomingSeenEvent setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
