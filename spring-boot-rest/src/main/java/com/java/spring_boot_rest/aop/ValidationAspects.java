package com.java.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspects {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspects.class);


    @Around("execution(* com.java.spring_boot_rest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
        if(postId < 0){
            LOGGER.info("postId is updating");
            postId = -postId;
            LOGGER.info("new postId is : "+ postId);
        }

        return jp.proceed(new Object[]{postId});
    }
}
