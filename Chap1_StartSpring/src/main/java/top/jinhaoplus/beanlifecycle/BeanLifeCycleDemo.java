package top.jinhaoplus.beanlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanlifecycle.xml");
        BeanWithAllLifeCycle bean = applicationContext.getBean(BeanWithAllLifeCycle.class);
        applicationContext.close();
    }
}
