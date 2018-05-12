package top.jinhaoplus.pizza.flow;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jinhaoplus.pizza.domain.*;
import top.jinhaoplus.pizza.service.customer.CustomerService;
import top.jinhaoplus.pizza.service.exception.CustomerNotFoundException;

import static org.apache.log4j.Logger.getLogger;
import static top.jinhaoplus.pizza.domain.enums.PaymentType.CREDIT_CARD;

@Component
public class PizzaFlowActions {
    private static final Logger LOGGER = getLogger(PizzaFlowActions.class);

    @Autowired
    private CustomerService customerService;

    public Customer lookupCustomer(String phoneNumber)
            throws CustomerNotFoundException {
        Customer customer = customerService.lookupCustomer(phoneNumber);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }

    public void addCustomer(Customer customer) {
        LOGGER.warn("TODO: 实际的添加客户逻辑");
    }

    public Payment verifyPayment(PaymentDetails paymentDetails) {
        Payment payment = null;
        if (paymentDetails.getPaymentType() == CREDIT_CARD) {
            payment = new CreditCardPayment();
        } else {
            payment = new CashOrCheckPayment();
        }

        return payment;
    }

    public void saveOrder(Order order) {
        LOGGER.warn("TODO: 实际的订单存储逻辑");
    }

    public boolean checkDeliveryArea(String zipCode) {
        LOGGER.warn("TODO: 实际的邮编校验逻辑");
        return "75075".equals(zipCode);
    }
}
