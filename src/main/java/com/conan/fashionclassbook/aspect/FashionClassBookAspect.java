package com.conan.fashionclassbook.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
//@Component
public class FashionClassBookAspect {

    @Pointcut("execution(public * com.conan.fashionclassbook.service.impl.*.*(..))")
    public void aspect() {}



    @Before("aspect()")
    public void before() {

        log.info("执行开始前执行...");
    }

    @After("aspect()")
    public void after() {
        log.info("执行开始后执行...");
    }

    @Around("aspect()")
    public void around(ProceedingJoinPoint point) throws Throwable {

        log.info("环绕前....");

        Signature signature = point.getSignature();
        log.info("signature : {} ", signature);

        Object proceed = point.proceed();
        log.info("proceed: {}", proceed);
        log.info("环绕后....");
    }
}
