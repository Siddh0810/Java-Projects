package com.java.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    return-type class-name.method-name(arguments)
    @Before("execution(* com.java.spring_boot_rest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    @After("execution(* com.java.spring_boot_rest.service.JobService.getJobs(..)) || execution(* com.java.spring_boot_rest.service.JobService.saveJobPost(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method executed: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.java.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecutedAfterException(JoinPoint jp){
        LOGGER.info("Method has some problem: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.java.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecutedOnSuccess(JoinPoint jp){
        LOGGER.info("Method ran successfully: " + jp.getSignature().getName());
    }

}