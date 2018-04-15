package top.jinhaoplus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.jinhaoplus.PlayerMain;

/**
 * 设置自动配置的配置Configuration时需要设置扫描的基础包，即需要指定扫描哪些包以完成配置
 * 指定方法：
 * 1. @ComponentScan无参：默认扫描和config同包(包括子包)
 * 2. @ComponentScan设置扫描包名(包括子包)
 * 3. @ComponentScan设置扫描类所处的包(包括子包)
 */
@Configuration
//@ComponentScan("top.jinhaoplus.autoconfig")
//@ComponentScan(basePackages = "top.jinhaoplus.autoconfig")
@ComponentScan(basePackageClasses = {PlayerMain.class})
public class CDPlayerConfig {
    // 这是一个空标记接口，只用来标记这是一个config
}
