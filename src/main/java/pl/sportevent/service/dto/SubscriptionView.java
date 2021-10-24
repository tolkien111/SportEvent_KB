package pl.justmedia.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import pl.justmedia.entity.Subscription;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Value
public class SubscriptionView {
    String subscriptionId;
    String subscriptionPaymentDone;
    String subscriptionDate;
    String subscriptionApproved;
    String eventTitle;
    String eventDate;
    String eventId;

}
