package top.jinhaoplus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jinhaoplus.model.StoreService;

@Controller
public class RestController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/cart")
    @ResponseBody
    public String cart() {
        System.out.println(storeService.getShoppingCart());
        // 两个http会话得到的ShoppingCart是不一样的，即Spring获得的shoppingCart这个bean是session级别的
        // top.jinhaoplus.model.ShoppingCart@c5fc08e
        // top.jinhaoplus.model.ShoppingCart@20e39137
        return "ok";
    }
}
