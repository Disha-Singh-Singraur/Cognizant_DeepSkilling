package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Exercise 3 & Exercise 8: LoggingAspect Class
 * Demonstrates Spring AOP (Aspect-Oriented Programming) by logging execution time,
 * as well as actions before and after method execution in service and repository classes.
 */
@Aspect
@Component
public class LoggingAspect {

    // Exercise 8: Before Advice
    @Before("execution(* com.library.service.BookService.*(..)) || execution(* com.library.repository.BookRepository.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LoggingAspect - Before] AOP Log: Starting execution of method: " + joinPoint.getSignature().getName());
    }

    // Exercise 8: After Advice
    @After("execution(* com.library.service.BookService.*(..)) || execution(* com.library.repository.BookRepository.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[LoggingAspect - After] AOP Log: Finished execution of method: " + joinPoint.getSignature().getName());
    }

    // Exercise 3: Around Advice to log execution times
    @Around("execution(* com.library.service.BookService.*(..)) || execution(* com.library.repository.BookRepository.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Proceed with the actual method execution
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("[LoggingAspect - Around] AOP Log: " + joinPoint.getSignature().getName() + " executed in " + executionTime + " ms");
        return result;
    }
}
