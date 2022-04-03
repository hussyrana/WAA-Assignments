package com.example.demo.aspect;

import com.example.demo.domain.Logger;
import com.example.demo.service.LoggerService;
import com.example.demo.service.LoggerServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void log(JoinPoint joinPoint){
        Logger l = new Logger();
        l.setDate(LocalDate.now());
        l.setTime(LocalTime.now());
        l.setPrincipal("Hassan");
        l.setOperation(joinPoint.getSignature().getName());
        loggerService.add(l);
//        System.out.println("chal gya a");
    }
    StopWatch a = new StopWatch();
    @Before("@annotation(com.example.demo.aspect.annotation.LoggerAnnotation)")
    public void log2(JoinPoint JoinPoint) {
        a.start();
    }
    @After("@annotation(com.example.demo.aspect.annotation.LoggerAnnotation)")
    public void log3(JoinPoint JoinPoint) {
        a.stop();
       System.out.println("Total time taken "+a.getTotalTimeMillis()+"ms");

    }
}
