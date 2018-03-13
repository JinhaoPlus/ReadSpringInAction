package top.jinhaoplus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import top.jinhaoplus.model.BlankDisc;

@Configuration
// @PropertySource为Environment提供外部属性的来源
@PropertySource("classpath:app.properties")
public class EnvironmentDiscConfig {

    // 属性文件app.properties会加载到environment中，
    // 后续将根据名称将加载到environment中的属性值解析出来
    // 这种解析可以有一些方式来实现：
    // 1. environment.getProperty显式查找
    // 2. PropertyPlaceholderConfigurer这一BeanPostProcessor后续装配的过程中根据其指定的外部配置装配到bean中去
    @Autowired
    private Environment environment;

    @Bean
    public BlankDisc disc(){
        return new BlankDisc(
                environment.getProperty("disc.title"),
                environment.getProperty("disc.artist"));
        // environment.getProperty("disc.title")
        // environment.getRequiredProperty("disc.title") 获取到必须定义的值，若没有此属性则抛出IllegalStateException
        // environment.getProperty("disc.title", "ccc") 带默认值的获取属性方法

        /**
         * Environment提供了方法来获取和上下文环境相关的元信息
         * environment.containsProperty(key) 上下文环境中是否key的属性
         * environment.getProperty(key) 上下文环境中获取key的属性
         * environment.getActiveProfiles() 上下文环境的激活的profiles
         * environment.getDefaultProfiles() 上下文环境的默认的profiles
         * environment.acceptsProfiles(profiles) 上下文环境的是否接受profiles
         *
         * 可以参考conditionalwiring一节的内容了解通过Environment来定义bean装配条件的方法
         * @Profile 注解实际上是通过environment.acceptsProfiles(profiles)来完成profiles装配的
         */


    }
}
