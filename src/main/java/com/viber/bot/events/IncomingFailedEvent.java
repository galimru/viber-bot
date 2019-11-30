package com.viber.bot.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingFailedEvent extends IncomingEvent {

    @JsonProperty(value = "user_id")
    protected String userId;

    @JsonProperty(value = "desc")
    protected String desc;

    public String getUserId() {
        return userId;
    }

    public IncomingFailedEvent setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public IncomingFailedEvent setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}