package pl.sportevent.service.exception;


public class BusinessServiceException extends RuntimeException{
    public BusinessServiceException(String message){
        super(message);
    }

    public BusinessServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
