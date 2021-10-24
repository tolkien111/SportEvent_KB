package pl.sportevent.service.dto;

import lombok.Getter;
import lombok.Value;
import pl.sportevent.entity.Subscription;
import pl.sportevent.entity.UserType;

import java.util.List;
import java.util.UUID;

@Value
public class PlayerView {
    UUID userId;
    String name;
    String email;
    UserType type;
}
