package spring_annotation.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.List;

//标注这个类是切面类
@Aspect
public class LogAspect {

    // 声明一个切面 切的是Calculator类的所有方法
    @Pointcut("execution(public * spring_annotation.bean.Calculator.*(..))")
    public void pointCut(){}

    //前置通知
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        List<Object> list = Arrays.asList(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature().getName()+"方法开始,参数："+list);
    }

    //后置方法
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法结束");
    }

    //后置返回方法
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturning(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"方法返回，返回内容："+result);
    }

    //后置异常方法
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logThrowing(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"方法返回异常，异常内容："+exception);
    }
}
