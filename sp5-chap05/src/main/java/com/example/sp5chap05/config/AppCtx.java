package com.example.sp5chap05.config;

import com.example.sp5chap05.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.example.sp5chap05.spring"})
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

//    @Bean
//    public MemberRegisterService memberRegSvc() {
//        return new MemberRegisterService();
//    }

//    @Bean
//    public ChangePasswordService changePwdSvc() {
//        return new ChangePasswordService();
//    }

//    @Bean
//    public MemberPrinter memberPrinter() {
//        return new MemberPrinter();
//    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }

    // Spring 컨테이너에 Bean을 등록함
    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter MemberInfoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setPrinter(memberPrinter2());
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

    @Bean
    public Client client() {
        Client client = new Client();
        client.setHost("host");
        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    public Client2 client2() {
        Client2 client2 = new Client2();
        client2.setHost("host");

        return client2;
    }
}
