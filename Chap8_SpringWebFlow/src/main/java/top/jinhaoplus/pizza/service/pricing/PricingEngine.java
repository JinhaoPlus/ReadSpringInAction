package top.jinhaoplus.pizza.service.pricing;


import top.jinhaoplus.pizza.domain.Order;

public interface PricingEngine {
    public float calculateOrderTotal(Order order);
}
