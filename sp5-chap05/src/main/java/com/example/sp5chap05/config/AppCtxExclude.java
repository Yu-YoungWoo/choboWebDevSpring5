package com.example.sp5chap05.config;


import com.example.sp5chap05.spring.MemberDao;
import com.example.sp5chap05.spring.MemberPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.example.sp5chap05.spring"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao"))
public class AppCtxExclude {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }
}
