package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {
        System.out.println("111111");
    }

    @Pointcut("@annotation(com.example.demo.anno.Profiled)")
    public void profiled() {
        System.out.println("profiled");
    }

    @Around("requestMapping() || profiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        String name = className + "." + methodName;

        System.out.println("called " + name);
        pjp.proceed();
        System.out.println("exit " + name );
        return null;
    }


}
