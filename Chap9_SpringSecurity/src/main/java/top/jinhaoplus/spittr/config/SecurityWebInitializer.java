package top.jinhaoplus.spittr.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// SpringSecurity的初始化器会创建出一系列的Filter来完成SpringSecurity的配置
// 1. SpringSecurity使用一个特殊的Filter，即DelegatingFilterProxy，它是一个拦截器代理，一般我们会把这个代理的filter-name设置为springSecurityFilterChain
// 2. 拦截器代理会寻找已经注入到Spring上下文中ID为springSecurityFilterChain的Filter bean，并把实际的filter操作委托给它
//    之所以proxy的filter-name会设置成与bean的ID相同是因为Spring会根据proxy的filter-name寻找Filter bean，而后者在Spring上下文初始化时就用了springSecurityFilterChain这个ID）

/**
 * 可以使用如下的xml配置来完成上述的配置过程
 * <filter>
 * <filter-name>springSecurityFilterChain</filter-name>
 * <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
 * </filter>
 * <p>
 * <filter-mapping>
 * <filter-name>springSecurityFilterChain</filter-name>
 * <url-pattern>/*</url-pattern>
 * </filter-mapping>
 */
// 3. AbstractSecurityWebApplicationInitializer实现了WebApplicationInitializer，因此Spring会发现它并作上下文的配置
// 4. AbstractSecurityWebApplicationInitializer会在Web容器中注册DelegatingFilterProxy
// 5. springSecurityFilterChain实际上是一个拦截器链，链接的一系列Filter可以提供各种安全保护功能
// 6. 所有的请求都会被DelegatingFilterProxy拦截并被springSecurityFilterChain处理
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
}
