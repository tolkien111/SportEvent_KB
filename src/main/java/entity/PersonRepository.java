package entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    List<Person> findByLastName (String lastName);
    List<Person> fingByEmailAddress(String emailAddress);

    List<Player> findByTeam(String teamName);
    List<Organizator> findByName(String organizatorName);
}
