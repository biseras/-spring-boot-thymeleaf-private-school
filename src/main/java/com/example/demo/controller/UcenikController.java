package com.example.demo.controller;

import com.example.demo.model.Ucenik;
import com.example.demo.service.UcenikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ucenik")
public class UcenikController {
    private final UcenikService ucenikService;

    public UcenikController(UcenikService ucenikService) {
        this.ucenikService = ucenikService;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
       // if (error != null && !error.isEmpty()) {
         ////   model.addAttribute("hasError", true);
        //    model.addAttribute("error", error);
       // }
        List<Ucenik> uceniks = this.ucenikService.listAll();
        model.addAttribute("ucenik", uceniks);
        model.addAttribute("bodyContent", "ucenik");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.ucenikService.deleteById(id);
        return "redirect:/ucenik";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.ucenikService.findById(id).isPresent()) {
            Ucenik ucenik = this.ucenikService.findById(id).get();
            model.addAttribute("ucenik", ucenik);
            model.addAttribute("bodyContent", "add-ucenik");
            return "master-template";
        }
        return "redirect:/uceniks?error=UcenikNotFound";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        model.addAttribute("bodyContent", "add-ucenik");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long id,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String datum,
            @RequestParam String adresa,
            @RequestParam String email) {
        if (id != null) {
            this.ucenikService.edit(id, ime, prezime, datum, adresa, email);
        } else {
            this.ucenikService.save(ime, prezime, datum, adresa, email);
        }
        return "redirect:/ucenik";
    }
}
