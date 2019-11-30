package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile {

    @JsonProperty(value = "id")
    protected String id;

    @JsonProperty(value = "name")
    protected String name;

    @JsonProperty(value = "avatar")
    protected String avatar;

    @JsonProperty(value = "country")
    protected String country;

    @JsonProperty(value = "language")
    protected String language;

    @JsonProperty("primary_device_os")
    protected String primaryDeviceOs;
    
    @JsonProperty(value = "api_version")
    protected Integer apiVersion;

    @JsonProperty(value = "viber_version")
    protected String viberVersion;

    @JsonProperty("mcc")
    protected String mcc;

    @JsonProperty("mnc")
    protected String mnc;

    @JsonProperty("device_type")
    protected String deviceType;

    @JsonProperty(value = "role")
    protected String role;

    public Profile() {
    }

    public Profile(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Profile setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Profile setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public Profile setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Profile setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Profile setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getPrimaryDeviceOs() {
        return primaryDeviceOs;
    }

    public Profile setPrimaryDeviceOs(String primaryDeviceOs) {
        this.primaryDeviceOs = primaryDeviceOs;
        return this;
    }

    public Integer getApiVersion() {
        return apiVersion;
    }

    public Profile setApiVersion(Integer apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public String getViberVersion() {
        return viberVersion;
    }

    public Profile setViberVersion(String viberVersion) {
        this.viberVersion = viberVersion;
        return this;
    }

    public String getMcc() {
        return mcc;
    }

    public Profile setMcc(String mcc) {
        this.mcc = mcc;
        return this;
    }

    public String getMnc() {
        return mnc;
    }

    public Profile setMnc(String mnc) {
        this.mnc = mnc;
        return this;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public Profile setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Profile setRole(String role) {
        this.role = role;
        return this;
    }
}
