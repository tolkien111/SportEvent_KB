package pl.sportevent.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findByUserLogin (String userLogin);
    List<User> findByUserEmail(String userEmail);
    List<Player> findByPlayerTeamName(String playerTeamName);
    List<Organizer> findByOrganizerName(String organizerName);
}
