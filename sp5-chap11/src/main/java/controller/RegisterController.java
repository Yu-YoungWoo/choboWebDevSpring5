package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {


    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }


    @RequestMapping("/register/step1")
    public String handleStep1() {
        return "register/step1";
    }


    @PostMapping("/register/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false")Boolean agree) {
        if(!agree) {
            return "register/step1";
        } else {
            return "register/step2";
        }
    }

    @GetMapping("/register/step2")
    public String handleStep2() {
        return "redirect:/register/step1";
    }


    @PostMapping("/register/step3")
    public String handleStep3(@ModelAttribute("formDatag") RegisterRequest regReq) {
        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException e) {
            return "register/step2";
        }
    }


}
