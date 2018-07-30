package spring_annotation.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 启动WEB时，会自动创建对象，调用方法来初始化对象及前端控制器
 */
@Configuration
@EnableWebMvc
public class MyWebMVCConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取根容器的配置类--父容器（SpringConfig）
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{(RootConfig.class)};
    }

    /**
     * SpringWeb容器--子容器
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{(ServletConfig.class)};
    }

    /**
     * 获取DispatchServlet的前端控制器拦截信息
     * @return
     */
    protected String[] getServletMappings() {
        //拦截所有请求和静态资源 但不包括/.jsp页面
        //所有不能用/*,这样不会拦截jsp
        return new String[]{"/"};
    }

}
