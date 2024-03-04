package com.winerte.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogAop {
    @Pointcut("execution(public * com.winerte.controller..*.*(..))")
    public void logPointCut() {
        System.out.println("logPointCut");
    }
    @Before("logPointCut()")
    public void beforeLog() {
        System.out.println("beforeLog");
    }
    @After("logPointCut()")
    public void afterLog() {
        System.out.println("afterLog");
    }
    @Around("logPointCut()")
    public void aroundLog() {
        System.out.println("aroundLog");
    }

}
