package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String getHomePage(@RequestParam(required = false) String error, Model model) {
        // if (error != null && !error.isEmpty()) {
        ////   model.addAttribute("hasError", true);
        //    model.addAttribute("error", error);
        // }
        model.addAttribute("bodyContent", "index");
        return "master-template";
    }

}
