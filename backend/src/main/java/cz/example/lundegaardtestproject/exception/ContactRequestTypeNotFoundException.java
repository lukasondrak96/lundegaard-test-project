package cz.example.lundegaardtestproject.exception;

public class ContactRequestTypeNotFoundException extends RuntimeException {

    public ContactRequestTypeNotFoundException(String message) {
        super(message);
    }
}
