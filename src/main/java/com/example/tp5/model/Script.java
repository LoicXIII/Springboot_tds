package com.example.tp5.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

public class Script {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String content;
    private String creationDate;

    @ManyToOne
    private Langage langue;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "Script", cascade = CascadeType.ALL)
    private List<History> history;

    public Script(int id, String title, String description, String content,String creationDate){
        super();
        this.id=id;
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
