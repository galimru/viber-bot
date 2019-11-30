package com.viber.bot.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viber.bot.events.EventType;
import com.viber.bot.messages.Location;
import com.viber.bot.messages.Profile;

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

    public AccountInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getChatHostname() {
        return chatHostname;
    }

    public AccountInfo setChatHostname(String chatHostname) {
        this.chatHostname = chatHostname;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccountInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public AccountInfo setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public AccountInfo setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public AccountInfo setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public AccountInfo setSubcategory(String subcategory) {
        this.subcategory = subcategory;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public AccountInfo setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AccountInfo setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getWebhook() {
        return webhook;
    }

    public AccountInfo setWebhook(String webhook) {
        this.webhook = webhook;
        return this;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public AccountInfo setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }

    public List<Profile> getMembers() {
        return members;
    }

    public AccountInfo setMembers(List<Profile> members) {
        this.members = members;
        return this;
    }

    public Integer getSubscribersCount() {
        return subscribersCount;
    }

    public AccountInfo setSubscribersCount(Integer subscribersCount) {
        this.subscribersCount = subscribersCount;
        return this;
    }
}
