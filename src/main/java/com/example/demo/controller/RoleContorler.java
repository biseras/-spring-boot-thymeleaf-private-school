package com.example.demo.controller;

import com.example.demo.enumerations.Role;
import com.example.demo.model.Exception.InvalidArgumentsException;
import com.example.demo.model.Exception.PasswordsDoNotMatchException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleContorler {
    private final UserService userService;
    private final UserRepository userRepository;

    public RoleContorler(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        //if(error != null && !error.isEmpty()) {
           // model.addAttribute("hasError", true);
           // model.addAttribute("error", error);
        //}
        List<User> userList=userRepository.findAll();
        model.addAttribute("user",userList);
        model.addAttribute("bodyContent","role");
        return "master-template";
    }

    @PostMapping("/urediuloga")
    public String urediuloga(@RequestParam String user,
                             @RequestParam Role role) {
        try{
            this.userService.urediuloga(user, role);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
