package pl.justmedia.service.exception;

import lombok.NonNull;

public class SubscriptionException extends BusinessServiceException {
    public SubscriptionException(@NonNull String message) {
        super(message);
    }
}
