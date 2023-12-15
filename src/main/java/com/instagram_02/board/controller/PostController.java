package com.instagram_02.board.controller;


import com.instagram_02.board.command.PostCommand;
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

    // controller 는 Service 와 가깝게 Service 는 Repository 와 가깝게 관계를 맺는 것이 이상적
    // private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        // orElse null 보단 orElseThrow 나 orElse(Post::new) 가 나음
        // model.addAttribute("post", postRepository.findById(id).orElse(null));
        model.addAttribute("post", postService.findById(id));
        return "post/view";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("postCommand", new PostCommand());
        return "post/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute PostCommand postCommand) {
        postService.save(postCommand.toEntity());
        return "redirect:/posts";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post",  postService.findById(id));
        return "post/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute Post post) {
        postService.update(id, post);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        postService.deleteById(id);
        return "redirect:/posts";
    }
}
