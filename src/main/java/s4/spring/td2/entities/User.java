package s4.spring.td2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Organization organization;

    @ManyToMany(mappedBy="users")
    private List<Groupe> groupes;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean suspended;

}
