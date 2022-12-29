package com.example.sp5chap08.spring;

public class ChangePasswordService {
    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd) {
        // email로 해당 Member 객체 가져옴(조회)
        Member member = memberDao.selectByEmail(email);

        if(member == null) {
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPwd, newPwd);

        // 해당 이메일이 있다면 update
        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
