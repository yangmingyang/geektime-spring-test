package com.mego.w10_annotation_aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect //表示当前类时一个切面
public class Logger {

    @Pointcut("execution(* *.mego.*.service.impl.*.*(..))")
    private void pt1(){}

    @Before("pt1()")
    public void printLog(){
        System.out.println("===前置通知===");
    }

    @AfterReturning("pt1()")
    public void printLogAfterReturning(){
        System.out.println("===后置通知===");
    }

    @AfterThrowing("pt1()")
    public void printLogAfterThrowing(){
        System.out.println("===异常通知===");
    }
    @After("pt1()")
    public void printLogAfter(){
        System.out.println("===最终通知===");
    }

    /**
     环绕通知
     问题：
        当我们配置了环绕通知之后，切入点放没有执行，而通知方法执行了。
     分析：
        通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     解决：
        Spring框架为我们提供了一个接口，ProceedingJoinPoint。该接口有一个方法proceed(),此方法就相当于明确调用切入点方法。
        该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     spring中的环绕通知：
        它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    //@Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint proceedingJoinPoint){
        Object rtValue = null;
        try {
            System.out.println("===前置通知1===");
            Object[] args = proceedingJoinPoint.getArgs();//得到方法执行所需的参数
            rtValue = proceedingJoinPoint.proceed(args);// 明确调用业务层方法（切入点方法）
            System.out.println("===后置通知1===");

        } catch (Throwable throwable) {
            System.out.println("===异常通知1===");
            throwable.printStackTrace();
        }finally {
            System.out.println("===最终通知1===");
        }
        return rtValue;
    }
}
