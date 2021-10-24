package pl.justmedia.service.exception;

public final class UserNotExistException extends BusinessServiceException {

    public UserNotExistException(String message) {
        super(message);
    }
}
