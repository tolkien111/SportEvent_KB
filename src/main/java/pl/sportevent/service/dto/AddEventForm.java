package pl.justmedia.service.dto;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class AddEventForm {
    UUID userId;
    String eventTitle;
    LocalDateTime eventDate;
    int eventPlayerLimit;
    double eventFee;
}
