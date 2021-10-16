package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
@Entity
@Table(name = "subscriptions")
@NoArgsConstructor(access = AccessLevel.PRIVATE) // for hibernate
@Getter
@EqualsAndHashCode
public class Subscription {
    @Id
    private UUID subscriptionId;
    private Person subscriptionPerson;
    private Boolean subscriptionPayment;

    public Subscription(@NonNull UUID subscriptionId,
                        @NonNull Person subscriptionPerson,
                        @NonNull Boolean subscriptionPayment) {
        this.subscriptionId = UUID.randomUUID();
        this.subscriptionPerson = subscriptionPerson;
        this.subscriptionPayment = subscriptionPayment;
    }
}
