package top.jinhaoplus.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class MagicExistsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // ConditionContext是编写装配条件时可以使用的Spring上下文，其中可以获取到
        // 1.context.getRegistry(): beanDefinitionRegistry即bean的定义
        // 2.context.getBeanFactory(): ConfigurableListableBeanFactory即bean的实际注入情况
        // 3.context.getEnvironment(): Environment即环境变量
        // 4.context.getResourceLoader(): ResourceLoader即加载资源
        // 5.context.getClassLoader(): ClassLoader即加载类
        Environment env = context.getEnvironment();

        // AnnotatedTypeMetadata在编写装配条件时可以捕捉到此bean除@Bean注解之外的其他注解的情况并做一些定制：比如有什么特定的注解才进行装配
        Map<String, Object> annotationMetadata = metadata.getAnnotationAttributes("org.springframework.context.annotation.Description");
        return env.containsProperty("magic") && annotationMetadata.get("value") != null;
    }

}
