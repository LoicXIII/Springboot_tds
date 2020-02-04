package s4.spring.td2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.td2.entities.Groupe;
import s4.spring.td2.entities.User;

import java.util.List;

public interface GroupRepository extends JpaRepository<Groupe, Integer> {
    List<User> findByName(String user_group);
    List<User> findByEmail(String email);

}
