package spring_annotation.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring容器
 */
@Configuration
@ComponentScan(
        basePackages = "spring_annotation.springmvc",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
)
public class RootConfig {
}
