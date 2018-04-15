package top.jinhaoplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.jinhaoplus.anno.Creamy;
import top.jinhaoplus.models.Dessert;

@Configuration
@ComponentScan(basePackageClasses = {Dessert.class})
public class AnnoDessertConfig {

    // 尝试向参数匹配装配好的类型是Dessert的bean而出现了歧义，因为有多个bean选择
    // No qualifying bean of type [top.jinhaoplus.models.Dessert] is defined: expected single matching bean but found 3: iceCream,cookies,cake
    @Bean
    // @Creamy实际上是@Qualifier注解的包装所以用法和@Qualifier保持一致，不过这样的注解可以看出来这里需要注入参数的特性
    public Dessert dessert(@Creamy Dessert dessert) {
        return dessert;
    }
}
