package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationMessage extends Message {

    @JsonProperty(value = "location")
    protected Location location;

    public LocationMessage() {
        super(MessageType.LOCATION);
    }

    public Location getLocation() {
        return location;
    }

    public LocationMessage setLocation(Location location) {
        this.location = location;
        return this;
    }
}
