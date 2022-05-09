package Exceptions;

public class NotFoundElement extends RuntimeException{
    public NotFoundElement(String message) {
        super(message);
    }
}
