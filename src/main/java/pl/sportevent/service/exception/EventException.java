package pl.justmedia.service.exception;

import lombok.NonNull;

public class EventException extends BusinessServiceException {
    public EventException (@NonNull String message) {
        super(message);
    }
}

