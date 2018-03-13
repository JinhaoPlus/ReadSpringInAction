package top.jinhaoplus.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.jinhaoplus.model.AnotherBlankDisc;

@Configuration
@ComponentScan(basePackageClasses = {AnotherBlankDisc.class})
public class PlaceholderDiscConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        // 和placeholder-config.xml中的配置方法实际上是相同的
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocations(new Resource[]{ new ClassPathResource("app.properties") });
        return configurer;
    }
}

