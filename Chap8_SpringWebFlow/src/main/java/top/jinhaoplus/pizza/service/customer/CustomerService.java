package top.jinhaoplus.pizza.service.customer;


import top.jinhaoplus.pizza.domain.Customer;
import top.jinhaoplus.pizza.service.exception.CustomerNotFoundException;

public interface CustomerService {
    Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}