package com.example.crud.controller;

import com.example.crud.domain.entity.MemberEntity;
import com.example.crud.domain.repository.MemberRepository;
import com.example.crud.dto.MemberDto;
import com.example.crud.service.MemberService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
        System.out.println("성공");
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("/member/login")
    public String login(@RequestParam(value = "error", required = false)String error,
                        @RequestParam(value = "exception", required = false)String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "member/login";
    }

    @PostMapping("/member/login")
    public ModelAndView loginProc(Long id) {
        ModelAndView mv = new ModelAndView();
//        Optional<MemberEntity> entity = repository.findById(id);
//        System.out.println("로그인객체"+entity);
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("/member/logout/result")
    public String logout() {
        return "member/logoutSuccess";
    }

}
