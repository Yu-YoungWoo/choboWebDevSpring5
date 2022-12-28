package com.example.sp5chap07.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {

    @Pointcut("execution(public * com.example.sp5chap07..*(..))")
    private void publicTarget() {}

    @Pointcut("execution(public  * com.example.sp5chap07.config..*(..))")
    private void publicTarget2() {}

    // !target(com.example.sp5chap07.config.AppCtx) -> AOP
//    @Around("publicTarget() && !target(com.example.sp5chap07.config.AppCtx)")
    @Around("publicTarget() && !target(com.example.sp5chap07.config.AppCtxWithCache)")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(), Arrays.toString(joinPoint.getArgs()),
                    (finish - start)
            );
        }
    }
}
