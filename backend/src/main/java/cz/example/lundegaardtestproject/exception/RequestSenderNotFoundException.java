package cz.example.lundegaardtestproject.exception;

public class RequestSenderNotFoundException extends RuntimeException {

    public RequestSenderNotFoundException(String message) {
        super(message);
    }
}
