package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Keyboard {

    @JsonProperty(value = "Type")
    protected String type;

    @JsonProperty(value = "Buttons")
    protected List<Button> buttons;

    @JsonProperty(value = "BgColor")
    protected String bgColor;

    @JsonProperty(value = "DefaultHeight")
    protected Boolean defaultHeight;

    @JsonProperty(value = "CustomDefaultHeight")
    protected Integer customDefaultHeight;

    @JsonProperty(value = "HeightScale")
    protected Integer heightScale;

    @JsonProperty(value = "ButtonsGroupColumns")
    protected Integer buttonsGroupColumns;

    @JsonProperty(value = "ButtonsGroupRows")
    protected Integer buttonsGroupRows;

    @JsonProperty(value = "InputFieldState")
    protected InputFieldState inputFieldState;

    @JsonProperty(value = "FavoritesMetadata")
    protected Object favoritesMetadata;

    public Keyboard() {
        this.type = "keyboard";
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public Keyboard setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    public String getBgColor() {
        return bgColor;
    }

    public Keyboard setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public Boolean getDefaultHeight() {
        return defaultHeight;
    }

    public Keyboard setDefaultHeight(Boolean defaultHeight) {
        this.defaultHeight = defaultHeight;
        return this;
    }

    public Integer getCustomDefaultHeight() {
        return customDefaultHeight;
    }

    public Keyboard setCustomDefaultHeight(Integer customDefaultHeight) {
        this.customDefaultHeight = customDefaultHeight;
        return this;
    }

    public Integer getHeightScale() {
        return heightScale;
    }

    public Keyboard setHeightScale(Integer heightScale) {
        this.heightScale = heightScale;
        return this;
    }

    public Integer getButtonsGroupColumns() {
        return buttonsGroupColumns;
    }

    public Keyboard setButtonsGroupColumns(Integer buttonsGroupColumns) {
        this.buttonsGroupColumns = buttonsGroupColumns;
        return this;
    }

    public Integer getButtonsGroupRows() {
        return buttonsGroupRows;
    }

    public Keyboard setButtonsGroupRows(Integer buttonsGroupRows) {
        this.buttonsGroupRows = buttonsGroupRows;
        return this;
    }

    public InputFieldState getInputFieldState() {
        return inputFieldState;
    }

    public Keyboard setInputFieldState(InputFieldState inputFieldState) {
        this.inputFieldState = inputFieldState;
        return this;
    }

    public Object getFavoritesMetadata() {
        return favoritesMetadata;
    }

    public Keyboard setFavoritesMetadata(Object favoritesMetadata) {
        this.favoritesMetadata = favoritesMetadata;
        return this;
    }
}
