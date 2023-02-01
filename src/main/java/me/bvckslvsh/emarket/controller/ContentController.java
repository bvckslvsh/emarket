package me.bvckslvsh.emarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/content/new")
    public String newContent(Model model){
        return "content";
    }

    @GetMapping("/content/edit/{id}")
    public String editContent(Model model){
        return "content";
    }

    @GetMapping("/content/delete/{id}")
    public String deleteContent(Model model){
        return "content";
    }
}
