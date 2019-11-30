package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Button {

    @JsonProperty(value = "Columns")
    protected Integer columns;

    @JsonProperty(value = "Rows")
    protected Integer rows;

    @JsonProperty(value = "BgColor")
    protected String bgColor;

    @JsonProperty(value = "Silent")
    protected Boolean silent;

    @JsonProperty(value = "BgMediaType")
    protected MediaType bgMediaType;

    @JsonProperty(value = "BgMedia")
    protected String bgMedia;

    @JsonProperty(value = "ImageScaleType")
    protected ScaleType imageScaleType;

    @JsonProperty(value = "BgLoop")
    protected Boolean bgLoop;

    @JsonProperty(value = "ActionType")
    protected ActionType actionType;

    @JsonProperty(value = "ActionBody")
    protected String actionBody;

    @JsonProperty(value = "Image")
    protected String image;

    @JsonProperty(value = "Text")
    protected String text;

    @JsonProperty(value = "TextVAlign")
    protected TextVAlign textVAlign;

    @JsonProperty(value = "TextHAlign")
    protected TextHAlign textHAlign;

    @JsonProperty(value = "TextPaddings")
    protected Integer[] textPaddings;

    @JsonProperty(value = "TextOpacity")
    protected Integer textOpacity;

    @JsonProperty(value = "TextSize")
    protected TextSize textSize;

    public Integer getColumns() {
        return columns;
    }

    public Button setColumns(Integer columns) {
        this.columns = columns;
        return this;
    }

    public Integer getRows() {
        return rows;
    }

    public Button setRows(Integer rows) {
        this.rows = rows;
        return this;
    }

    public String getBgColor() {
        return bgColor;
    }

    public Button setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public Boolean getSilent() {
        return silent;
    }

    public Button setSilent(Boolean silent) {
        this.silent = silent;
        return this;
    }

    public MediaType getBgMediaType() {
        return bgMediaType;
    }

    public Button setBgMediaType(MediaType bgMediaType) {
        this.bgMediaType = bgMediaType;
        return this;
    }

    public String getBgMedia() {
        return bgMedia;
    }

    public Button setBgMedia(String bgMedia) {
        this.bgMedia = bgMedia;
        return this;
    }

    public ScaleType getImageScaleType() {
        return imageScaleType;
    }

    public Button setImageScaleType(ScaleType imageScaleType) {
        this.imageScaleType = imageScaleType;
        return this;
    }

    public Boolean getBgLoop() {
        return bgLoop;
    }

    public Button setBgLoop(Boolean bgLoop) {
        this.bgLoop = bgLoop;
        return this;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Button setActionType(ActionType actionType) {
        this.actionType = actionType;
        return this;
    }

    public String getActionBody() {
        return actionBody;
    }

    public Button setActionBody(String actionBody) {
        this.actionBody = actionBody;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Button setImage(String image) {
        this.image = image;
        return this;
    }

    public String getText() {
        return text;
    }

    public Button setText(String text) {
        this.text = text;
        return this;
    }

    public TextVAlign getTextVAlign() {
        return textVAlign;
    }

    public Button setTextVAlign(TextVAlign textVAlign) {
        this.textVAlign = textVAlign;
        return this;
    }

    public TextHAlign getTextHAlign() {
        return textHAlign;
    }

    public Button setTextHAlign(TextHAlign textHAlign) {
        this.textHAlign = textHAlign;
        return this;
    }

    public Integer[] getTextPaddings() {
        return textPaddings;
    }

    public Button setTextPaddings(Integer[] textPaddings) {
        this.textPaddings = textPaddings;
        return this;
    }

    public Integer getTextOpacity() {
        return textOpacity;
    }

    public Button setTextOpacity(Integer textOpacity) {
        this.textOpacity = textOpacity;
        return this;
    }

    public TextSize getTextSize() {
        return textSize;
    }

    public Button setTextSize(TextSize textSize) {
        this.textSize = textSize;
        return this;
    }
}
