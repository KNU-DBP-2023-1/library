package com.knu.library.controller;

import com.knu.library.domain.LoginDTO;
import com.knu.library.domain.Member;
import com.knu.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signup(@ModelAttribute("member") Member member) {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute Member member) {
        memberService.save(member);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
        return "member/login";
    }

    @PostMapping("/login")
    public String loginLogic(@ModelAttribute LoginDTO loginDTO) {
        Member loginMember = memberService.login(loginDTO.getId(), loginDTO.getPw());

        if (loginMember == null) {
            System.out.println("로그인 에러");
            return "member/login";
        }

        //로그인 성공 처리 TODO

        return "redirect:/";
    }

}
