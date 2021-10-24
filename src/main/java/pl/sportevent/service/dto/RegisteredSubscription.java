package pl.justmedia.service.dto;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class RegisteredSubscription {
    @NonNull
    UUID userId;
    UUID subscriptionId;
}
