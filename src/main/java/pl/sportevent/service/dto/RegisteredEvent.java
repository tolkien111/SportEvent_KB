package pl.sportevent.service.dto;

import lombok.NonNull;
import lombok.Value;
import pl.sportevent.entity.Event;

import java.util.UUID;

@Value
public class RegisteredEvent {

    @NonNull
    UUID userId;
    UUID eventId;
}
