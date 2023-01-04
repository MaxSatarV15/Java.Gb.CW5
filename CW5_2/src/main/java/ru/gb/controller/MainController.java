package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")//@RequestParam(name="name", required = false, defaultValue = "World") String name,
    public String home(Model model) {
        model.addAttribute("title", "Main Menu");
        return "home";
    }
}
