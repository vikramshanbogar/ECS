package org.example.address;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* org.example.address.*.*(..) )")
    public void myPointcut() {

    }

    @Pointcut(value = "execution(* org.example.address.*.*(..) )")
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