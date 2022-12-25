package com.example.sp5chap05.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("listPrinter")
public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    // MemberListPrinter Class에 MemberDao MemberPrinter를 의존주입(DI) 함
    // 생성자로 DI
    public MemberListPrinter() {}

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m));
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    @Qualifier("summaryPrinter")
    public void sretPrinter(MemberPrinter printe) {
        this.printer = printer;
    }
}
