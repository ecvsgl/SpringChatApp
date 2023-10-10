package com.devexperts.ria.internship.chatify.exception;


import java.time.LocalDateTime;

public class ChatifyExceptionTemplate {
    private int statusCode;
    private String exceptionMessage;
    private LocalDateTime exceptionDate;

    public ChatifyExceptionTemplate() {
    }

    public ChatifyExceptionTemplate(int statusCode, String exceptionMessage, LocalDateTime exceptionDate) {
        this.statusCode = statusCode;
        this.exceptionMessage = exceptionMessage;
        this.exceptionDate = exceptionDate;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public LocalDateTime getExceptionDate() {
        return exceptionDate;
    }

    public void setExceptionDate(LocalDateTime exceptionDate) {
        this.exceptionDate = exceptionDate;
    }

    @Override
    public String toString() {
        return "ChatifyExceptionTemplate{" +
                "statusCode=" + statusCode +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                ", exceptionDate=" + exceptionDate +
                '}';
    }
}
