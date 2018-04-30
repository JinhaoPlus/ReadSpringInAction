package top.jinhaoplus.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// @EnableWebMvc说明此配置是一个Spring MVC配置
@EnableWebMvc
// @ComponentScan组件扫描可以定义集中Web相关的上下文需要的组件的位置
@ComponentScan("top.jinhaoplus.spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * ViewResolver组件用以配置视图解析器
     * InternalResourceViewResolver配置了根据视图名去查找视图文件的位置
     * 默认的ViewResolver是BeanNameViewResolver会查找beanID和视图名相同的实现了View的bean作为视图
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * configureDefaultServletHandling用以配置静态资源是否通过默认Servlet来处理
     * 如果使用DispatcherServlet来处理静态资源会造成映射解析的浪费，因此使用Web Container自身的默认Servlet直接处理静态资源
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

}
