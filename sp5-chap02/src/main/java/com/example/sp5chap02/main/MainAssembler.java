package com.example.sp5chap02.main;

import com.example.sp5chap02.assembler.Assembler;
import com.example.sp5chap02.spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainAssembler {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("명령어를 입력하세요");
            String command = reader.readLine();

            if(command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }

            if(command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if(command.equals("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static Assembler assembler = new Assembler();

    private static void processNewCommand(String[] arg) {
        if(arg.length != 5) {
            printHelp();
            return;
        }
        MemberRegisterService regSvc = assembler.getRegSvc();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("비밀번호가 일치하지 않습니다. \n");
            return;
        }

        try {
            regSvc.register(req);
            System.out.println("등록했습니다. \n");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다. \n");
        }
    }

    public static void processChangeCommand(String[] arg) {
        if(arg.length != 4) {
            printHelp();
            return;
        }

        ChangePasswordService changePwdSvc = assembler.getPwdSvc();

        try {
            changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호를 번경했습니다. \n");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다. \n");
        } catch (WrongIdPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다. \n");
        }
    }

    public static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
        System.out.println("명령어 사용법: ");
        System.out.println("new 이메일 이름 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }
}
