package com.example.sp5chap07.config;

import com.example.sp5chap07.Calculator;
import com.example.sp5chap07.ExeTimeCalculator;
import com.example.sp5chap07.RecCalculator;
import com.example.sp5chap07.aspect.ExeTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) // AOP 프록시 자동 생성 어노테이션
public class AppCtx {

    // AOP를 사용하여 처리하는 코드 또한 참조를 당하면 -> 순환 참조 오류 발생
    // 따라서 해당 Bean은 참조하지 않도록 만들어야 함
    // @Around("publicTarget() && !target(com.example.sp5chap07.config.AppCtx)")
    // 참조 -> https://velog.io/@hyeriful/Spring-Introduction-AOP-%EC%88%9C%ED%99%98-%EC%B0%B8%EC%A1%B0-%EB%B0%9C%EC%83%9D%EC%9D%B4%EC%9C%A0%EC%99%80-%ED%95%B4%EA%B2%B0
    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }



}
