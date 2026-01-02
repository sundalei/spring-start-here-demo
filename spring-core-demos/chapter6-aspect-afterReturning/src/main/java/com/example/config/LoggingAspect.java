package com.example.config;

import java.util.logging.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

  private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

  // @Around("execution(* com.example.services.*.*(..))")
  @AfterReturning(value = "@annotation(com.example.ToLog)", returning = "returnedValue")
  public Object log(Object returnedValue) {

    logger.info("Method executed and returned " + returnedValue);
    return returnedValue;
  }
}
