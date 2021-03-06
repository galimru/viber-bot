package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StickerMessage extends Message {

    @JsonProperty(value = "sticker_id")
    private Integer stickerId;

    public StickerMessage() {
        super(MessageType.STICKER);
    }

    public Integer getStickerId() {
        return stickerId;
    }

    public StickerMessage setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
        return this;
    }
}
