package com.viber.bot.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactMessage extends Message {

    @JsonProperty(value = "contact")
    protected Contact contact;

    public ContactMessage() {
        super(MessageType.CONTACT);
    }

    public Contact getContact() {
        return contact;
    }

    public ContactMessage setContact(Contact contact) {
        this.contact = contact;
        return this;
    }
}
