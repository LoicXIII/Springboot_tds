package s4.spring.td2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getAliases() {
        return aliases;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

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
