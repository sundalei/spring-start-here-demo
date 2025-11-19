package com.example.config;

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
    LOG.info("Method will execute");
    Object result = joinPoint.proceed();
    LOG.info("Method executed");
    return result;
  }
}
