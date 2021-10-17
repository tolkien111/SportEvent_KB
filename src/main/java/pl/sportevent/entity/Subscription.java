package pl.sportevent.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
@NoArgsConstructor(access = AccessLevel.PRIVATE) // for hibernate
@Getter
public class Subscription {

    @Id
    private UUID subscriptionId;
    private boolean subscriptionPaymentDone;
    private LocalDateTime subscriptionDate;
    private boolean subscriptionApporoved;

    public Subscription(@NonNull boolean subscriptionPaymentDone,
                        @NonNull LocalDateTime subscriptionDate,
                        @NonNull boolean subscriptionApporoved) {
        this.subscriptionId = UUID.randomUUID();
        this.subscriptionPaymentDone = subscriptionPaymentDone;
        this.subscriptionDate = subscriptionDate;
        this.subscriptionApporoved = subscriptionApporoved;
    }
}
