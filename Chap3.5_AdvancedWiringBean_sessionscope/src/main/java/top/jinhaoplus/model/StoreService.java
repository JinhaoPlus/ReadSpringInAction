package top.jinhaoplus.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    // 不同的用户发起的请求是不同session中的，想要让service需要注入的shoppingCart属于不同的session就要使得shoppingCart的作用域是在session范围的
    @Autowired
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
