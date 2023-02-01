package me.bvckslvsh.emarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
public class UserController {

    public String userPage(Principal principal, Model model){
        return "userPage";
    }
}
