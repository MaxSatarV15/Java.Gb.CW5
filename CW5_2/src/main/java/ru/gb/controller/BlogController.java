package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Post;
import ru.gb.repository.PostRepository;
import ru.gb.service.PostService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

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

    @GetMapping("/posts/{id}")
    public String posts_ByID(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "post";
    }
}





























