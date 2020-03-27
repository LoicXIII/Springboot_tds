package com.example.tp5.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Script {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String content;
    private String creationDate;

    @ManyToOne
    private Language language;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "scripts", cascade = CascadeType.ALL)
    private List<History> history;


    public Script(){

    }

    public Script(String title, String description, String content,String creationDate){
        this.title=title;
        this.description=description;
        this.content=content;
        this.creationDate=creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
