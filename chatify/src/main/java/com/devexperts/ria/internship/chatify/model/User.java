package com.devexperts.ria.internship.chatify.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_entity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    private String username;

    private String password;


}
