package com.example.config;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    
    private final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        LOG.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
        
        Object returnedByMethod = joinPoint.proceed();

        LOG.info("Method executed and returned " + returnedByMethod);
        return returnedByMethod;
    }
}
