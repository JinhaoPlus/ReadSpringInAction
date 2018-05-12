package top.jinhaoplus.pizza.service.order;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import top.jinhaoplus.pizza.domain.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    @Override
    public void saveOrder(Order order) {
        LOGGER.debug("SAVING ORDER:  ");
        LOGGER.debug("   Customer:  " + order.getCustomer().getName());
        LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
        LOGGER.debug("   Payment:  " + order.getPayment());
    }
}
