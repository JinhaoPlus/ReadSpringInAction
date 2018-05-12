package top.jinhaoplus.pizza.service.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
