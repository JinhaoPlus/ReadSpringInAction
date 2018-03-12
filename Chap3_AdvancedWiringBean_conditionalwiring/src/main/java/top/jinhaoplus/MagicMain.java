package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.MagicConfig;

import java.util.Arrays;

public class MagicMain {
    public static void main(String[] args) {
        System.setProperty("magic", "ccc");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MagicConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanNames).forEach(beanName -> {
            System.out.println(beanName);
        });
    }
}
