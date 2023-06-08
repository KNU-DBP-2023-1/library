package com.knu.library.controller;

import com.knu.library.domain.LoginDTO;
import com.knu.library.domain.Member;
import com.knu.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String loginLogic(@ModelAttribute LoginDTO loginDTO, HttpServletRequest request) {
        Member loginMember = memberService.login(loginDTO.getId(), loginDTO.getPw());

        if (loginMember == null) {
            System.out.println("[MemberController] loginMember is null");
            return "member/login";
        }

        //로그인 성공 처리 TODO
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute("loginMember", loginMember);

        return "redirect:/bookList";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); //세션 내 정보를 삭제
        }
        return "redirect:/";
    }

}
