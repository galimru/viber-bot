package com.viber.bot.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserStatus {

    @JsonProperty(value = "id")
    protected String id;

    @JsonProperty(value = "online_status")
    protected Integer onlineStatus;

    @JsonProperty(value = "online_status_message")
    protected String onlineStatusMessage;

    @JsonProperty(value = "last_online")
    protected Date lastOnline;

    public String getId() {
        return id;
    }

    public UserStatus setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public UserStatus setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
        return this;
    }

    public String getOnlineStatusMessage() {
        return onlineStatusMessage;
    }

    public UserStatus setOnlineStatusMessage(String onlineStatusMessage) {
        this.onlineStatusMessage = onlineStatusMessage;
        return this;
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public UserStatus setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
        return this;
    }
}
