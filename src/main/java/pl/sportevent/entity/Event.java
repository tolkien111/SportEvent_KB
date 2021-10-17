package pl.sportevent.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode

public class Event {
    @Id
    private UUID eventId;
    private String eventTitle;
    private LocalDateTime eventDate;
    private int eventPlayerLimit;
    private double eventFee;
    @OneToMany
    @JoinColumn(name = "event_id")
    private List<Subscription> eventSubscriptions;

    public Event(@NonNull String eventTitle,
                 @NonNull LocalDateTime eventDate,
                 @NonNull int eventPlayerLimit,
                 @NonNull double eventFee) {
        this.eventId = UUID.randomUUID();
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventPlayerLimit = eventPlayerLimit;
        this.eventFee = eventFee;
        this.eventSubscriptions = new ArrayList<>();
    }
}
