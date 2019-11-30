package com.viber.bot.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingWebhookEvent extends IncomingEvent {

    @JsonProperty(value = "event_types")
    protected List<EventType> eventTypes;

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public IncomingWebhookEvent setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }
}
