package com.viber.bot.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.messages.Profile;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails extends ApiResponse {

    @JsonProperty(value = "user")
    protected Profile user;

    public Profile getUser() {
        return user;
    }

    public UserDetails setUser(Profile user) {
        this.user = user;
        return this;
    }
}
