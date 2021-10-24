package pl.justmedia.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;
import pl.justmedia.service.dto.SubscriptionView;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "subscriptions")
@NoArgsConstructor(access = AccessLevel.PRIVATE) // for hibernate
@Getter
@EqualsAndHashCode

public class Subscription {
    @Id
    private UUID subscriptionId;
    private boolean subscriptionPaymentDone;
    private LocalDateTime subscriptionDate;
    private boolean subscriptionApproved;
   @OneToOne()
   @JoinColumn(name = "event_id")

    private Event event;

    public Subscription(Boolean subscriptionPaymentDone,
                        LocalDateTime subscriptionDate,
                        Boolean subscriptionApproved,
                        Event event) {
        this.subscriptionId =  UUID.randomUUID();
        this.subscriptionPaymentDone = subscriptionPaymentDone;
        this.subscriptionDate = subscriptionDate;
        this.subscriptionApproved = subscriptionApproved;
        this.event = event;
    }

    public SubscriptionView toView(){
        return new SubscriptionView(
                subscriptionId.toString(),
                Boolean.toString(subscriptionPaymentDone),
                subscriptionDate.toString(),
                Boolean.toString(subscriptionApproved),
                event.getEventTitle(),
                event.getEventDate().toString(),
                event.getEventId().toString());
    }
}
