package top.jinhaoplus.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
// 设置proxyMode = ScopedProxyMode.TARGET_CLASS会使用CGLIB来创建代理ShoppingChar注入到StoreService中去，而并不是将真正的bean注入
// 当storeService调用shoppingCart的时候这个注入的代理会进行懒解析并将调用委托给真正的bean
public class ShoppingCart {
}
