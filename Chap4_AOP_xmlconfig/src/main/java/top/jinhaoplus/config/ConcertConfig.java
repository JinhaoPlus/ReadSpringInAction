package top.jinhaoplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.jinhaoplus.AudienceAspect;
import top.jinhaoplus.concert.Concert;
import top.jinhaoplus.concert.Performance;

@Configuration
// 开启AspectJ式注解的开关，可以自己通过扫描包获取到需要织入的Aspect
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "top.jinhaoplus")
public class ConcertConfig {

    @Bean
    public Performance concert() {
        return new Concert();
    }

    @Bean
    public AudienceAspect audience() {
        return new AudienceAspect();
    }
}
