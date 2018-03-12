package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.AnnoDessertConfig;

import java.util.Arrays;

public class AnnoDessertMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoDessertConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanNames).forEach(beanName -> {
            System.out.println(beanName);
        });
    }
}
