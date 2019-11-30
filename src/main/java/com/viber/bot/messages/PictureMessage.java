package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PictureMessage extends Message {

    @JsonProperty(value = "text")
    protected String text;

    @JsonProperty(value = "media")
    protected String media;

    @JsonProperty(value = "thumbnail")
    protected String thumbnail;

    public PictureMessage() {
        super(MessageType.PICTURE);
    }

    public String getText() {
        return text;
    }

    public PictureMessage setText(String text) {
        this.text = text;
        return this;
    }

    public String getMedia() {
        return media;
    }

    public PictureMessage setMedia(String media) {
        this.media = media;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public PictureMessage setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }
}
