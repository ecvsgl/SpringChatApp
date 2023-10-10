package com.devexperts.ria.internship.chatify.model.dto;

import com.devexperts.ria.internship.chatify.model.Message;

import java.time.LocalDateTime;
import java.util.List;

public class MessageResponse {

    private String username;

    private String message;

    private LocalDateTime date;

    public MessageResponse() {
    }

    public MessageResponse(String username, String message, LocalDateTime date) {
        this.username = username;
        this.message = message;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
