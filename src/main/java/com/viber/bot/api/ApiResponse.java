package com.viber.bot.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    @JsonProperty(value = "status")
    private Integer status;

    @JsonProperty(value = "status_message")
    private String statusMessage;

    public Integer getStatus() {
        return status;
    }

    public ApiResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public ApiResponse setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }
}
