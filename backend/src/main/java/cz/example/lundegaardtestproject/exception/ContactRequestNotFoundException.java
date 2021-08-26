package cz.example.lundegaardtestproject.exception;

public class ContactRequestNotFoundException extends RuntimeException {

    public ContactRequestNotFoundException(String message) {
        super(message);
    }
}
