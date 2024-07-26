package com.vikram.customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.vikram.customers.*.*(..) )")
    public void myPointcut() {

    }

    @Pointcut(value = "execution(* com.vikram.customers.*.*(..) )")
    public void myPointcut123() {

    }

    @Before("myPointcut()")
    public void beforeAdvice(JoinPoint jp) {
        log.info("in method : {}", jp.getSignature().getName());
    }

    @After("myPointcut()")
    public void afterAdvise(JoinPoint jp) {
        log.info("completed method : {}, {}", jp.getSignature().getName(), jp.getTarget().getClass().toString());
    }

}