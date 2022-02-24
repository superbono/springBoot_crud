package com.example.crud.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class MainController {

    @GetMapping("/")
    public String main() {
        return "main";
    }
}
