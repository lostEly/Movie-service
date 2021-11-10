package com.illia.krasnienkov.movie.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class MyAspect {
    private static final Logger LOGGER = LogManager.getLogger(MyAspect.class);

    @Pointcut("within(com.illia.krasnienkov.movie..*)")
    public void callAtMyServicePublic() {
    }

    @Before("callAtMyServicePublic()")
    public void aroundCallAt(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        LOGGER.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        LOGGER.info("after " + jp.toString());
    }
}
