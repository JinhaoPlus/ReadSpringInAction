package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.DataSourceConfig;

import java.util.Arrays;

public class JavaConfigProfilesMain {
    // 1. 运行时的JVM系统属性可改变profiles: JAVA_OPTS="-Dspring.profiles.active=prod"
    public static void main(String[] args) {
        // 2. 设置系统环境变量可改变profiles
        System.setProperty("spring.profiles.active","prod");
        // 3. Web应用中可设置上下文参数改变profiles
        // 4. Web应用中可设置DispatcherServlet初始化参数改变profiles
        // 5. JNDI条目改变profiles
        // 6. 集成测试的@ActiveProfiles改变profiles
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        // 设置spring.profiles.active属性，装配bean的时候会装配这个profiles下的bean
        // 不设置spring.profiles.active属性，但是设置了spring.profiles.default属性，装配bean的时候会装配这个profiles下的bean
        // 不设置spring.profiles.active属性和spring.profiles.default属性，则只装配无profiles的bean
        Arrays.asList(beanNames).forEach(beanName -> {
            System.out.println(beanName);
        });
    }
}
