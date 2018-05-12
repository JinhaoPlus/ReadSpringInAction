package top.jinhaoplus.pizza.domain;


public class CreditCardPayment extends Payment {
    private String authorization;

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "CREDIT:  $" + getAmount() + " ; AUTH: " + authorization;
    }
}
