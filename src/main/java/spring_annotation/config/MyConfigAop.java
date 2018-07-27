package spring_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring_annotation.bean.Calculator;
import spring_annotation.bean.LogAspect;

@Configuration
//开启AOP功能
@EnableAspectJAutoProxy
public class MyConfigAop {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
