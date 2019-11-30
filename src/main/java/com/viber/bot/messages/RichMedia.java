package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichMedia {

    @JsonProperty(value = "Type")
    protected String type;

    @JsonProperty(value = "ButtonsGroupColumns")
    protected Integer buttonsGroupColumns;

    @JsonProperty(value = "ButtonsGroupRows")
    protected Integer buttonsGroupRows;

    @JsonProperty(value = "BgColor")
    protected String bgColor;

    @JsonProperty(value = "Buttons")
    protected List<Button> buttons;

    public String getType() {
        return type;
    }

    public RichMedia setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getButtonsGroupColumns() {
        return buttonsGroupColumns;
    }

    public RichMedia setButtonsGroupColumns(Integer buttonsGroupColumns) {
        this.buttonsGroupColumns = buttonsGroupColumns;
        return this;
    }

    public Integer getButtonsGroupRows() {
        return buttonsGroupRows;
    }

    public RichMedia setButtonsGroupRows(Integer buttonsGroupRows) {
        this.buttonsGroupRows = buttonsGroupRows;
        return this;
    }

    public String getBgColor() {
        return bgColor;
    }

    public RichMedia setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public RichMedia setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }
}
