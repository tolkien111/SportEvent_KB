package pl.justmedia.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EventsRepository extends JpaRepository <Event, UUID> {

    List<Event> findByEventTitle (String eventTitle);
    List<Event> findByEventDate (LocalDateTime eventDate);
    @Query("from Subscription s where s.event = (?1)")
    List<Subscription> findEventSubscriptions(Event event);
    //list aproved
}
