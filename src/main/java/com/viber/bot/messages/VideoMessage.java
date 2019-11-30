package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoMessage extends Message {

    @JsonProperty(value = "media")
    protected String media;

    @JsonProperty(value = "size")
    protected Integer size;

    @JsonProperty(value = "duration")
    protected Integer duration;

    @JsonProperty(value = "thumbnail")
    protected String thumbnail;

    public VideoMessage() {
        super(MessageType.VIDEO);
    }

    public String getMedia() {
        return media;
    }

    public VideoMessage setMedia(String media) {
        this.media = media;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public VideoMessage setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public VideoMessage setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public VideoMessage setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }
}
