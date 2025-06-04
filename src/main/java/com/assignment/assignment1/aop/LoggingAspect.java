package com.assignment.assignment1.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    // Intercept all methods in com.example.demo.service.MyService
    @Around("execution(* com.assignment.assignment1..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("Before: "+ joinPoint.getSignature() +" - "+ Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed(); // Proceed to the original method

        logger.debug("Returned: " + result);

        return result;
    }

    @AfterThrowing(
            pointcut = "execution(* com.assignment.assignment1..*(..))",
            throwing = "ex")
    public void logAfterThrowing(ProceedingJoinPoint joinPoint, Exception ex) throws Throwable {
        logger.error("Exception : in  "+ joinPoint.getSignature()+ ": "+  ex.getClass().getSimpleName());

        Object result = joinPoint.proceed();

        logger.error(result.toString());
        // You could also log this with a logging framework like SLF4J
    }
}