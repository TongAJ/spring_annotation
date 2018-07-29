package spring_annotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_annotation.bean.Calculator;
import spring_annotation.config.MyConfigAop;
import spring_annotation.ext.ExtConfig;

import java.util.Collection;

public class AnnotationExtTest {
    /**
     * Get IOC use AnnotationConfigApplicationContext
     */
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);

    @Test
    public void testExt(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("name = " + name);
        }

        context.publishEvent(new ApplicationEvent(new String("publishEvent")) {
        });
    }


}
