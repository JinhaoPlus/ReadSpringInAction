package top.jinhaoplus.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Java Web应用运行环境使用Servlet标准，这套标准制定了Web应用启动和运行的流程
 * 实现了这套Servlet标准的Web Server（如Tomcat、Jetty）将为Web应用提供运行环境，即Servlet Container
 * Servlet 3.0的标准中，Servlet Container会在classpath中寻找实现了javax.servlet.ServletContainerInitializer接口的类
 * 1. Spring提供的org.springframework.web.SpringServletContainerInitializer实现了ServletContainerInitializer
 * 2. SpringServletContainerInitializer会查找org.springframework.web.WebApplicationInitializer来配置Container的启动
 * 3. org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer就是WebApplicationInitializer的使用注解配置的基本实现
 * 4. SpitterWebInitializer继承AbstractAnnotationConfigDispatcherServletInitializer就可以做用户级的Container配置了
 * AbstractAnnotationConfigDispatcherServletInitializerhui创建出DispatcherServlet和ContextLoaderListener
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 两个应用上下文
     * 1. DispatcherServlet加载的应用上下文，主要定义了应用上下文中跟Web相关的部分，如控制器Controller、视图解析器ViewResolver、处理器映射HandlerMapping等
     * getServletConfigClasses会将返回的配置指定给DispatcherServlet来创建上下文
     * 2. ContextLoaderListener加载的应用上下文，主要定义了应用上下文中Web之外的部分，如Service中间层组件、Repository数据层组件等
     * getRootConfigClasses会将返回的配置指定给ContextLoaderListener来创建上下文
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    // 将 / 映射到默认的请求分发DispatcherServlet上，会处理所有的请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}