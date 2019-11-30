package com.viber.bot.message;

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
    
    @JsonProperty(value = "api_version")
    protected Integer apiVersion;

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

    public Integer getApiVersion() {
        return apiVersion;
    }

    public Profile setApiVersion(Integer apiVersion) {
        this.apiVersion = apiVersion;
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
