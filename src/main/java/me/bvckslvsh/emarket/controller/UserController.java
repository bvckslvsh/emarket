package me.bvckslvsh.emarket.controller;

import me.bvckslvsh.emarket.domain.Content;
import me.bvckslvsh.emarket.domain.User;
import me.bvckslvsh.emarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping("/register")
    public String registerPage(Model model){
        return "registerPage";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String password,
                               @RequestParam String email,
                               Model model) {
        User user = new User(name, password, email);
        userRepository.save(user);
        return ("redirect:/home");
    }


}
