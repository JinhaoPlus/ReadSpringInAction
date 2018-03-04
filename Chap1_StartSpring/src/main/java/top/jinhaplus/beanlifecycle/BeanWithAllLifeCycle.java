package top.jinhaplus.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring bean的生命周期：使用拓展点来在生命周期中变更bean的属性或执行各种操作
 * XXXAware接口的意思是「可感知到XXX的」，也就是说实现这个接口的bean是可以感知到某些资源的存在的，感知的方式就是通过接口定义的setXXX方法来设置这些资源
 * <p>
 * -> 调用constructor实例化bean: constructor-arg参数在此处设置
 * -> 填充属性，property参数在此处设置
 * -> BeanNameAware接口的setBeanName回调，可以在这里对设置beanName后做操作
 * -> BeanFactory接口的setBeanFactory回调，可以在这里对设置beanFactory后做操作
 * -> ApplicationContextAware接口的setApplicationContext回调，可以在这里对设置applicationContext后做操作
 * => 注册的beanPostProcessor的postProcessBeforeInitialization方法对初始化前的bean做处理
 * -> InitializingBean接口的afterPropertiesSet回调，可以在这里对执行init-method前做操作
 * -> init-method执行，可以做自定义初始化方法
 * => 注册地beanPostProcessor的postProcessAfterInitialization方法对初始化后的bean做处理
 * -> bean初始化结束，可供使用
 * -> DisposableBean接口的destroy回调，可以在这里对执行destroy-method前做操作
 * -> destroy-method执行，可以做自定义的销毁方法
 * </p>
 */
public class BeanWithAllLifeCycle implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {

    private String beanName;
    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;
    private String propt;
    private String value;

    public BeanWithAllLifeCycle(String propt) {
        System.out.println("constructor invoked");
        this.propt = propt;
    }

    public void initBean() {
        System.out.println("initBean invoked");
    }

    public void setValue(String value) {
        System.out.println("setValue invoked");
        this.value = value;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName invoked");
        beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory invoked");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext invoked");
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet invoked");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy invoked");
    }

    public void destroyBean() {
        System.out.println("destroyBean invoked");
    }


}
