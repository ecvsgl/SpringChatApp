package com.devexperts.ria.internship.chatify.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    @Column(name="username")
    private String username;

    @Column(name="message")
    private String message;

    @Column(name="date")
    private LocalDateTime date;

    public Message() {
    }

    public Message(String username, String message, LocalDateTime date) {
        this.username = username;
        this.message = message;
        this.date = date;
    }

    public Long getId() {
        return messageId;
    }

    public void setId(Long id) {
        this.messageId = id;
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
        return "Message{" +
                "messageId=" + messageId +
                ", username='" + username + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
