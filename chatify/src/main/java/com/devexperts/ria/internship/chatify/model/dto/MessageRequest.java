package com.devexperts.ria.internship.chatify.model.dto;

public class MessageRequest {

    private String username;

    private String message;

    public MessageRequest() {
    }

    public MessageRequest(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
