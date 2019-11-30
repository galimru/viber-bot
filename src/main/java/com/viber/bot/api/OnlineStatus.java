package com.viber.bot.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnlineStatus extends ApiResponse {

    @JsonProperty(value = "users")
    protected List<UserStatus> users;

    public List<UserStatus> getUsers() {
        return users;
    }

    public OnlineStatus setUsers(List<UserStatus> users) {
        this.users = users;
        return this;
    }
}
