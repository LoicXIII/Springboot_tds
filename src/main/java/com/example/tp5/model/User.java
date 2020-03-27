package com.example.tp5.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private List<Script> scripts;

    private String login;

    private String password;

    private String email;

    private String identity;

    public User() {

    }

    public User(String login, String password, String email,String identity) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.identity=identity;
    }
}