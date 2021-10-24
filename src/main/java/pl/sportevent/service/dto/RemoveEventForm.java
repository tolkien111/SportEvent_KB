package pl.sportevent.service.dto;

import lombok.Value;
import pl.sportevent.entity.Event;

import java.util.UUID;

@Value
public class RemoveEventForm {
    UUID userId;
    Event event;
}
