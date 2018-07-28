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


    /**
     * 总结:
     *      1）、@EnableAspectJAutoProxy开启AOP功能
     *      2）、容器中注入一个AnnotationAwareAspectJAutoProxyCreator组件
     *      3）、后置处理器AnnotationAwareAspectJAutoProxyCreator
     *      4）、容器的创建流程：
     *          1：refresh()方法中this.registerBeanPostProcessors(beanFactory);注册后置处理器，
     *              创建后置处理器AnnotationAwareAspectJAutoProxyCreator对象
     *          2:调用this.finishBeanFactoryInitialization(beanFactory);
     *                 1--初始化剩下的单实例Bean，创建业务逻辑对象和切面对象，其中后置处理器会拦截对象
     *                 2--AnnotationAwareAspectJAutoProxyCreator后置处理器会来拦截对象的初始化
     *                 3--组件创建完成后，判断是否需要增强
     *                      是：切面的通知方法包装成增强器（Advisor），给业务逻辑对象创建CGLIB的代理对象
     *      5）、CglipAopProxy.interceptor()
     *          1：得到目标方法的拦截器链（增强器包装成MethodInterceptor）
     *          2：利用拦截器的链式机制，依次进入每一个拦截器进行执行
     *          3：效果
     *                  1--正常返回-->前置通知、目标方法、后置通知、后置返回通知
     *                  2--异常返回-->前置通知、目标方法、后置通知、后置异常通知
     */
    @Test
    public void testAop(){
        Calculator calculator = context.getBean(Calculator.class);
        calculator.div(1,1);
        calculator.div(1,0);
    }


}
