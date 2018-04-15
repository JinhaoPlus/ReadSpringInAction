package top.jinhaoplus.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.jinhaoplus.models.Dessert;

@Configuration
@ComponentScan(basePackageClasses = {Dessert.class})
public class DessertConfig {

    // 尝试向参数匹配装配好的类型是Dessert的bean而出现了歧义，因为有多个bean选择
    // No qualifying bean of type [top.jinhaoplus.models.Dessert] is defined: expected single matching bean but found 3: iceCream,cookies,cake
    @Bean
    // @Qualifier可以：
    // 1. 在javaconfig中设置在装配参数上以表示需要被注入的bean的限定符：默认是beanName
    // 2. 在autoconfig中设置与@Autowired一起使用以表示需要被注入的bean的限定符：默认是beanName
    public Dessert dessert(@Qualifier("softDessert") Dessert dessert) {
        return dessert;
    }
}
