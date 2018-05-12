package top.jinhaoplus.pizza.service.payment;


import org.springframework.stereotype.Component;
import top.jinhaoplus.pizza.service.exception.PaymentException;

@Component("paymentProcessor")
public class PaymentProcessor {

    public void approveCreditCard(String creditCardNumber, String expMonth, String expYear, float amount) throws PaymentException {
        if (amount > 20.00) {
            throw new PaymentException();
        }
    }
}
