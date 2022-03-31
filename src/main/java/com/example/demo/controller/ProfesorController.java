package com.example.demo.controller;

import com.example.demo.model.Profesor;
import com.example.demo.service.ProfesorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        // if (error != null && !error.isEmpty()) {
        ////   model.addAttribute("hasError", true);
        //    model.addAttribute("error", error);
        // }
        List<Profesor> profesors = this.profesorService.listAll();
        model.addAttribute("profesor", profesors);
        model.addAttribute("bodyContent", "profesor");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.profesorService.deleteById(id);
        return "redirect:/profesor";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.profesorService.findById(id).isPresent()) {
            Profesor profesor = this.profesorService.findById(id).get();
            model.addAttribute("profesor", profesor);
            model.addAttribute("bodyContent", "add-profesor");
            return "master-template";
        }
        return "redirect:/profesor?error=UcenikNotFound";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        model.addAttribute("bodyContent", "add-profesor");
        return "master-template";
    }
    @GetMapping("/details/{id}")
    public String addDetailsPage(Model model, @PathVariable Long id) {
        if (this.profesorService.findById(id).isPresent()) {
            Profesor profesor = this.profesorService.findById(id).get();
            model.addAttribute("profesor", profesor);
            model.addAttribute("bodyContent", "readmore-profesor");
            return "master-template";
        }
        return "redirect:/profesor?error=UcenikNotFound";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long id,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String objasnuvanje,
            @RequestParam String biografija,
            @RequestParam String obrazovanieirabotnoiskustvo,
            @RequestParam String datumodkogaraboti,
            @RequestParam String email) {
        if (id != null) {
            this.profesorService.edit(id, ime, prezime, objasnuvanje, biografija, obrazovanieirabotnoiskustvo, datumodkogaraboti, email);
        } else {
            this.profesorService.save(ime, prezime, objasnuvanje, biografija, obrazovanieirabotnoiskustvo, datumodkogaraboti, email);
        }
        return "redirect:/profesor";
    }
}
