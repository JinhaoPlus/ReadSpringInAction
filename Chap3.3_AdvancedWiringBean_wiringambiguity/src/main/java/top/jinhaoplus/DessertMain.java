package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.DessertConfig;

import java.util.Arrays;

public class DessertMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DessertConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanNames).forEach(beanName -> {
            System.out.println(beanName);
        });
    }
}
