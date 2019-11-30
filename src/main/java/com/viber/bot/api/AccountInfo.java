package com.viber.bot.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.event.EventType;
import com.viber.bot.message.Location;
import com.viber.bot.message.Profile;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountInfo extends ApiResponse {

    @JsonProperty(value = "id")
    protected String id;

    @JsonProperty(value = "chat_hostname")
    protected String chatHostname;

    @JsonProperty(value = "name")
    protected String name;

    @JsonProperty(value = "uri")
    protected String uri;

    @JsonProperty(value = "icon")
    protected String icon;

    @JsonProperty(value = "category")
    protected String category;

    @JsonProperty(value = "subcategory")
    protected String subcategory;

    @JsonProperty(value = "location")
    protected Location location;

    @JsonProperty(value = "country")
    protected String country;

    @JsonProperty(value = "webhook")
    protected String webhook;

    @JsonProperty(value = "event_types")
    protected List<EventType> eventTypes;

    @JsonProperty(value = "members")
    protected List<Profile> members;

    @JsonProperty(value = "subscribers_count")
    protected Integer subscribersCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatHostname() {
        return chatHostname;
    }

    public void setChatHostname(String chatHostname) {
        this.chatHostname = chatHostname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public List<Profile> getMembers() {
        return members;
    }

    public void setMembers(List<Profile> members) {
        this.members = members;
    }

    public Integer getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(Integer subscribersCount) {
        this.subscribersCount = subscribersCount;
    }
}
