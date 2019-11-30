package com.viber.bot.message;

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

    @JsonProperty(value = "Text")
    protected String text;

    @JsonProperty(value = "TextSize")
    protected TextSize textSize;

    @JsonProperty(value = "TextHAlign")
    protected TextHAlign textHAlign;

    @JsonProperty(value = "TextVAlign")
    protected TextVAlign textVAlign;

    @JsonProperty(value = "ActionType")
    protected ActionType actionType;

    @JsonProperty(value = "ActionBody")
    protected String actionBody;

    @JsonProperty(value = "Image")
    protected String image;

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

    public String getText() {
        return text;
    }

    public Button setText(String text) {
        this.text = text;
        return this;
    }

    public TextSize getTextSize() {
        return textSize;
    }

    public Button setTextSize(TextSize textSize) {
        this.textSize = textSize;
        return this;
    }

    public TextHAlign getTextHAlign() {
        return textHAlign;
    }

    public Button setTextHAlign(TextHAlign textHAlign) {
        this.textHAlign = textHAlign;
        return this;
    }

    public TextVAlign getTextVAlign() {
        return textVAlign;
    }

    public Button setTextVAlign(TextVAlign textVAlign) {
        this.textVAlign = textVAlign;
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
}
