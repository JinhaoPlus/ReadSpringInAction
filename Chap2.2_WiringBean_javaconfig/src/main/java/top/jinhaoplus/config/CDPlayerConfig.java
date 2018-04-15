package top.jinhaoplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.jinhaoplus.model.disc.CompactDisc;
import top.jinhaoplus.model.disc.SgtPeppers;
import top.jinhaoplus.model.player.CDPlayer;

// @Configuration相当于xmlconfig中的<beans>
@Configuration
public class CDPlayerConfig {

    // @Bean相当于xmlconfig中的<bean>
    // @Bean用于方法创建bean并注入进Spring容器中
    @Bean
    //可指定注入到容器中的bean名称 @Bean(name="sgtPeppersDisc")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    // 使用@Bean时带上参数，Spring会在容器中尽可能寻找满足要求的bean来作为参数
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        // 使用sgtPeppers()时由于该方法已被@Bean注解，所以会被Spring拦截其调用并直接返回该方法创建的bean，即Spring中已经注册的bean
        //return new CDPlayer(sgtPeppers());

        return new CDPlayer(compactDisc);
    }

}
