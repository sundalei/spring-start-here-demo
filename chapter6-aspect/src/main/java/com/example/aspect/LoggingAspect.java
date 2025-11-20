package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  private final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

  @Around("execution(* com.example.services.*.*(..))")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    String signature = joinPoint.getSignature().toShortString();
    LOG.info("{} will execute", signature);
    Object result = joinPoint.proceed();
    LOG.info("{} executed", signature);
    return result;
  }
}
