package top.jinhaoplus.pizza.service.customer;


import org.springframework.stereotype.Service;
import top.jinhaoplus.pizza.domain.Customer;
import top.jinhaoplus.pizza.service.exception.CustomerNotFoundException;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    public CustomerServiceImpl() {
    }

    @Override
    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
        if ("9725551234".equals(phoneNumber)) {
            Customer customer = new Customer();
            customer.setId(123);
            customer.setName("Craig Walls");
            customer.setAddress("3700 Dunlavy Rd");
            customer.setCity("Denton");
            customer.setState("TX");
            customer.setZipCode("76210");
            customer.setPhoneNumber(phoneNumber);
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }
}
