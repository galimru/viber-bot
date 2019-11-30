package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileMessage extends Message {

    @JsonProperty(value = "media")
    protected String media;

    @JsonProperty(value = "size")
    protected Integer size;

    @JsonProperty(value = "file_name")
    protected String fileName;

    public FileMessage() {
        super(MessageType.FILE);
    }

    public String getMedia() {
        return media;
    }

    public FileMessage setMedia(String media) {
        this.media = media;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public FileMessage setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public FileMessage setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
