package com.example.config;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecurityAspect {
    
    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around(value = "@annotation(com.example.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security Aspect: Calling the intercepted method");

        Object returnedValue = joinPoint.proceed();
        
        logger.info("Security Aspect: Method executed and returned " + returnedValue);

        return returnedValue;
    }
}
