package entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;

@Entity
@Table(name = "events")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class Event {
    private UUID eventId;
    private Organizator eventOraganizator;
    private LocalDateTime eventDate;
    private String eventName;
    private Integer eventPlayerLimit;
    private double eventFee;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscirption_id")
    private LinkedHashSet<Subscription> subscriptions = new LinkedHashSet();
}
