package com.example.tp5.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

public class Langage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "Langage", cascade = CascadeType.ALL)
    private List<Script> script;

    public Langage(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
