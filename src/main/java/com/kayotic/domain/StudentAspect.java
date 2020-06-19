package com.kayotic.domain;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

    //Pointcut and advice

    @Before("execution(* com.kayotic.*.get*())")
    public void getGetterAdvice(){
        System.out.println("Getter is called");
    }
}