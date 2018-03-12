package top.jinhaoplus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaoplus.model.Notepad;
import top.jinhaoplus.model.UniqueThing;

public class BeanScopeMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("scoped-beans.xml");
        // singleton是默认的beanScope，从applicationContext每次获取到的都是单例
        System.out.println(applicationContext.getBean(UniqueThing.class));
        System.out.println(applicationContext.getBean(UniqueThing.class));
        // prototype的beanScope从applicationContext每次获取到的都是通过模版生成的新的bean
        System.out.println(applicationContext.getBean(Notepad.class));
        System.out.println(applicationContext.getBean(Notepad.class));
    }
}
