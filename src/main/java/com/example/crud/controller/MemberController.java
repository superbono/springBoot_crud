package com.example.crud.controller;

import com.example.crud.domain.repository.MemberRepository;
import com.example.crud.dto.MemberDto;
import com.example.crud.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository repository;
    private final MemberService service;

    @GetMapping("/member/regist")
    public String join() {
        return "member/regist";
    }

//    @PostMapping("/member/regist")
//    public ModelAndView joinProc(MemberDto dto) {
//        ModelAndView mv = new ModelAndView();
//        service.join(dto);
//        System.out.println("성공");
//        return mv;
//    }

    @PostMapping("/member/regist")
    public ModelAndView  joinProc(MemberDto dto) {
        ModelAndView mv = new ModelAndView();
        service.join(dto);
        System.out.println("성공");
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("/member/login")
    public String login() {
        return "member/login";
    }
}
