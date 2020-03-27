package com.example.tp5.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private String password;
    private String email;
    private String identity;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private List<Script> script;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


    public User(){
        this(0,"","","","");
    }


    public User(int id, String login, String password, String email, String identity){
        super();
        this.id=id;
        this.login=login;
        this.password=password;
        this.email=email;
        this.identity=identity;
    }



}
