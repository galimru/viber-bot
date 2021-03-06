package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrlMessage extends Message {

    protected String media;

    public UrlMessage() {
        super(MessageType.URL);
    }

    public String getMedia() {
        return media;
    }

    public UrlMessage setMedia(String media) {
        this.media = media;
        return this;
    }
}
