package spring_annotation.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringMVC容器
 */
@Configuration
@ComponentScan(
        basePackages = "spring_annotation.springmvc",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
        useDefaultFilters = false
)
public class ServletConfig extends WebMvcConfigurerAdapter {

    /**
     * 将静态资源交给tomcat去处理
     * <mvc:default-servlet-handler />
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //default return this.jsp("/WEB-INF/", ".jsp");
        //you can define a new ViewResolvers strategy
        registry.jsp("/WEB-INF/views",".jsp");
    }
}
