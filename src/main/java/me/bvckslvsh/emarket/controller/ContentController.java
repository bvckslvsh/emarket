package me.bvckslvsh.emarket.controller;

import me.bvckslvsh.emarket.domain.Content;
import me.bvckslvsh.emarket.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;


    @GetMapping("/content/new")
    public String newContent(Model model){
        Iterable<Content> contents = contentRepository.findAll();
        model.addAttribute("contents", contents);
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
