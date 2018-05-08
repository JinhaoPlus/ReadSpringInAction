package top.jinhaoplus.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import top.jinhaoplus.spittr.web.filter.LogFilter;
import top.jinhaoplus.spittr.web.servlet.AdminServlet;

import javax.servlet.*;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 重写WebApplicationInitializer的onStartup方法就可以自定义Filter和Servlet了
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 在servlet上下文中Listener、Servlet、Filter都抽象成为Registration.Dynamic而存在
        // 比如我们可以自己添加DispatcherServlet到servlet上下文中，但是AbstractAnnotationConfigDispatcherServletInitializer提供了更优雅的实现
        /*
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", dispatcherServlet);
        appServlet.addMapping("/");
        */

        FilterRegistration.Dynamic logFilter = servletContext.addFilter("logFilter", LogFilter.class);
        logFilter.addMappingForUrlPatterns(null, false, "/");

        ServletRegistration.Dynamic adminServlet = servletContext.addServlet("adminServlet", AdminServlet.class);
        adminServlet.addMapping("/admin");

        super.onStartup(servletContext);
    }

    // 等同于在上述自添加DispatcherServlet到servlet上下文时的
    // appServlet.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads"));
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/Users/jinhaoplus/Desktop", 2097152, 4194304, 0));
    }
}