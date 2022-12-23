package com.example.sp5chap02.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);

        if(member == null) {
            System.out.println("데이터 없음 \n");
            return;
        }

        printer.print(member);
        System.out.println();
    }


    // setter 메소드로 DI
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
