package top.jinhaoplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import top.jinhaoplus.model.MagicBean;

@Configuration
public class MagicConfig {

    @Bean
    // @Conditional条件装配，装配此bean的条件是@Conditional的value是一个类，这个类实现了Condition接口，调用其matches方法判断是否满足装配条件
    @Conditional(MagicExistsCondition.class)
    @Description("aaa")
    public MagicBean magicBean() {
        return new MagicBean();
    }

}