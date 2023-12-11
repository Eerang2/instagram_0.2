package com.instagram_02.board.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class frontController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("index");
        return "post/list";
    }

//    @GetMapping("/posts")
//    public String posts(Model model) {
//        model.addAttribute("posts");
//        return "posts";
//    }
}
