package pl.justmedia.service.dto;

import lombok.Getter;
import lombok.Value;
import pl.justmedia.entity.Subscription;
import pl.justmedia.entity.UserType;

import java.util.List;
import java.util.UUID;

@Value
public class PlayerView {
    UUID userId;
    String name;
    String email;
    UserType type;
}
