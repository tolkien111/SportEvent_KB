package pl.sportevent.service.dto;

import lombok.Value;
import pl.sportevent.entity.Event;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class AddSubscriptionForm {
   UUID userId;
   boolean subscriptionPaymentDone;
   LocalDateTime subscriptionDate;
   boolean subscriptionApproved;
   Event event;
}
