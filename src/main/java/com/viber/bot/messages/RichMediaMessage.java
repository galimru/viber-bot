package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichMediaMessage extends Message {

    @JsonProperty(value = "rich_media")
    protected RichMedia richMedia;

    protected String alternativeText;

    public RichMediaMessage() {
        super(MessageType.RICH_MEDIA);
    }

    public RichMedia getRichMedia() {
        return richMedia;
    }

    public RichMediaMessage setRichMedia(RichMedia richMedia) {
        this.richMedia = richMedia;
        return this;
    }

    public String getAlternativeText() {
        return alternativeText;
    }

    public RichMediaMessage setAlternativeText(String alternativeText) {
        this.alternativeText = alternativeText;
        return this;
    }

    @Override
    public Map<String, Object> getCustomProperties() {
        return Collections.singletonMap("alt_text", alternativeText);
    }
}
