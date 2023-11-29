package com.example.www_lab_week6.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.www_lab_week6.backend.models.User;
import com.example.www_lab_week6.backend.repositories.UserRepository;
import com.example.www_lab_week6.backend.services.UserServices;
import jakarta.servlet.http.HttpSession;


@Controller
//@RequestMapping("/users")
@NoArgsConstructor @AllArgsConstructor
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServices userServices;

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") String id){
        return "index";
    }

    @GetMapping("/add-form")
    @RequestMapping("/add-form")
    public String show(HttpSession session , Model model){
        User  user = (User) session.getAttribute("userLogin");
        user =new User();
        model.addAttribute("user",user);
        return "users/add-form";
    }
    public String add(@ModelAttribute User user, Model model){
        userRepository.save(user);
        return "/";
    }
    @RequestMapping("/show-login-page")
    public String show_login( Model model){
        model.addAttribute("user", new User());
        return "users/login";
    }
//    @PostMapping("/login")
//    public String login(@ModelAttribute User user, Model model){
////        User us = userServices.login(user.getEmail(), user.getPasswordHash());
//        return "index";
//    }

    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String email, @RequestParam String password){
        User user =  userServices.login(email, password);
        if(user!=null){
//            user.setLastLogin(LocalDateTime.now());

            session.setAttribute("userLogin", user);
            return "redirect:/add-form";
        }
        return  "redirect:/show-login-page";
    }


}