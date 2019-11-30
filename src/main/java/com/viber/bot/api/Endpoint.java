package com.viber.bot.api;

public enum Endpoint {
    SET_WEBHOOK("/set_webhook"),
    SEND_MESSAGE("/send_message"),
    GET_ACCOUNT_INFO("/get_account_info"),
    GET_USER_DETAILS("/get_user_details"),
    GET_ONLINE_STATUS("/get_online");

    private String path;

    Endpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
