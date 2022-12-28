package com.example.sp5chap07.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCut {

    @Pointcut("execution(public * com.example.sp5chap07..*(..))")
    public void commonTarget() {}
}
