package me.bvckslvsh.emarket.controller;

import me.bvckslvsh.emarket.domain.Content;
import me.bvckslvsh.emarket.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;


    @GetMapping("/content/catalog")
    public String catalog(Model model){
        Iterable<Content> contents = contentRepository.findAll();
        model.addAttribute("contents", contents);
        return "contentCatalog";
    }

    @GetMapping("/content/new")
    public String newContent(Model model){
        return "newContent";
    }

    @PostMapping("/content/new")
    public String newContentAdd(@RequestParam String title,
                                @RequestParam BigDecimal price,
                                @RequestParam String description,
                                @RequestParam String imageurl,
                                Model model) {

        Content content = new Content(title, price, description, imageurl);
        contentRepository.save(content);
        return "redirect:/content/catalog";
    }

    @GetMapping("/content/{id}")
    public String detailedContent(@PathVariable(value = "id") long id, Model model){

        if(!contentRepository.existsById(id)) {
            return "redirect:/content/catalog";
        }


        Optional<Content> content = Optional.ofNullable(contentRepository.findById(id));
        ArrayList<Content> contentArrayList = new ArrayList<>();
        content.ifPresent(contentArrayList::add);
        model.addAttribute("content", contentArrayList);

        return "content";
    }


}
