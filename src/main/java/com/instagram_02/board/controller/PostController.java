package com.instagram_02.board.controller;


import com.instagram_02.board.entity.Post;
import com.instagram_02.board.repository.PostRepository;
import com.instagram_02.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "post/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElse(null));
        return "post/view";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElse(null));
        return "post/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute Post post) {
        postService.update(id, post);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        postRepository.deleteById(id);
        return "redirect:/posts";
    }
}
