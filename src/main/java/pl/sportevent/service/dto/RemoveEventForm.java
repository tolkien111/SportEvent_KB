package pl.justmedia.service.dto;

import lombok.Value;
import pl.justmedia.entity.Event;

import java.util.UUID;

@Value
public class RemoveEventForm {
    UUID userId;
    Event event;
}
