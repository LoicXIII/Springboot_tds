package s4.spring.td2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;
    private String domain;
    private String aliases;

    @OneToMany(cascade= CascadeType.ALL,mappedBy="organization")
    private List<Groupe> groupes;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "organization")
    private List<User> users;

    public Organization(){

    }
    public Organization(String name, String domain, String aliases)
    {
        this.name=name;
        this.domain=domain;
        this.aliases=aliases;
    }
}
