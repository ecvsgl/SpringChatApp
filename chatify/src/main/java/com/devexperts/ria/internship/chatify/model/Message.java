package com.devexperts.ria.internship.chatify.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message_entity")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", username='" + username + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
