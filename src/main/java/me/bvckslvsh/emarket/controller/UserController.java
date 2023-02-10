package me.bvckslvsh.emarket.controller;

import me.bvckslvsh.emarket.domain.Content;
import me.bvckslvsh.emarket.domain.User;
import me.bvckslvsh.emarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable(value = "id") long id,  Model model){
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> userArrayList = new ArrayList<>();
        user.ifPresent(userArrayList::add);
        model.addAttribute("user", userArrayList);
        return "user";
    }

}
