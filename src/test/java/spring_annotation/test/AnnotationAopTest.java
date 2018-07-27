package spring_annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_annotation.bean.Calculator;
import spring_annotation.config.MyConfigAop;
import spring_annotation.config.MyConfigProfile;

import javax.sql.DataSource;

public class AnnotationAopTest {
    /**
     * Get IOC use AnnotationConfigApplicationContext
     */
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigAop.class);

    @Test
    public void testAop(){
        Calculator calculator = context.getBean(Calculator.class);
        calculator.div(1,1);
        calculator.div(1,0);
    }


}
