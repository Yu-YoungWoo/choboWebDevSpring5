package com.example.sp5chap04.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

    public MemberRegisterService() {}

    public Long register(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null) {
            throw new DuplicateMemberException("dup email" + req.getEmail());
        }
        Member newMember = new Member(
                req.getEmail(),
                req.getPassword(),
                req.getName(),
                LocalDateTime.now()
        );
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
