package com.viber.bot.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.events.EventType;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetWebhook {

    @JsonProperty(value = "url")
    protected String url;

    @JsonProperty(value = "event_types")
    protected List<EventType> eventTypes;

    @JsonProperty(value = "send_name")
    protected Boolean sendName;

    @JsonProperty(value = "send_photo")
    protected Boolean sendPhoto;

    public String getUrl() {
        return url;
    }

    public SetWebhook setUrl(String url) {
        this.url = url;
        return this;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public SetWebhook setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }

    public Boolean getSendName() {
        return sendName;
    }

    public SetWebhook setSendName(Boolean sendName) {
        this.sendName = sendName;
        return this;
    }

    public Boolean getSendPhoto() {
        return sendPhoto;
    }

    public SetWebhook setSendPhoto(Boolean sendPhoto) {
        this.sendPhoto = sendPhoto;
        return this;
    }
}
