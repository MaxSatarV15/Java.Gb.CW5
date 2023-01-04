package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.model.Post;
import ru.gb.repository.PostRepository;
import ru.gb.service.PostService;

@Controller
public class BlogController {
//    private PostService postService;
    private PostRepository postRepository;
    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public String post(Model model) {
        model.addAttribute("title", "Blog");
        model.addAttribute("posts", postRepository.findAll());//.getAllPost()
        return "/posts";
    }

    @GetMapping("/posts/add-post")
    public String post_add(Model model) {
        return "/post-add";
    }

    @PostMapping("/posts/add-post")
    public String post_add_post(@RequestParam String name,  Model model) {//this name <-> name="name" in post-add.html
        Post post = new Post(name);
        postRepository.save(post);
        return "redirect:/posts";
    }
}





























