package pl.sportevent.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EventsRepository extends JpaRepository <Event, UUID> {

    List<Event> findByEventDate (LocalDateTime eventDate);

    List<Event> findByEventTitle (String eventTitle);

}
