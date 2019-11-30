package com.viber.bot.message;

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

    public void setType(String type) {
        this.type = type;
    }

    public Integer getButtonsGroupColumns() {
        return buttonsGroupColumns;
    }

    public void setButtonsGroupColumns(Integer buttonsGroupColumns) {
        this.buttonsGroupColumns = buttonsGroupColumns;
    }

    public Integer getButtonsGroupRows() {
        return buttonsGroupRows;
    }

    public void setButtonsGroupRows(Integer buttonsGroupRows) {
        this.buttonsGroupRows = buttonsGroupRows;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }
}
