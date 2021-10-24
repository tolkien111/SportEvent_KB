package pl.justmedia.service.dto;

import lombok.NonNull;
import lombok.Value;
import pl.justmedia.entity.Event;

import java.util.UUID;

@Value
public class RegisteredEvent {

    @NonNull
    UUID userId;
    UUID eventId;
}
