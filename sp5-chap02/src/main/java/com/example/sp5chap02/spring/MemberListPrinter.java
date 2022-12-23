package com.example.sp5chap02.spring;

import java.util.Collection;

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter printer;

    // MemberListPrinter Class에 MemberDao MemberPrinter를 의존주입(DI) 함
    // 생성자로 DI
    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
        this.memberDao = memberDao;
        this.printer = printer;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m));
    }
}
