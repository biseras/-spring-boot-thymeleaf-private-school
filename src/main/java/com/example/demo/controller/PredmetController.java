package com.example.demo.controller;

import com.example.demo.model.Predmet;
import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.service.PredmetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/predmet")
public class PredmetController {
    private final PredmetService predmetService;
    private final ProfesorRepository profesorRepository;

    public PredmetController(PredmetService predmetService, ProfesorRepository profesorRepository) {
        this.predmetService = predmetService;
        this.profesorRepository = profesorRepository;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        // if (error != null && !error.isEmpty()) {
        ////   model.addAttribute("hasError", true);
        //    model.addAttribute("error", error);
        // }
        List<Predmet> predmets = this.predmetService.listAll();
        model.addAttribute("predmet", predmets);
        model.addAttribute("bodyContent", "predmet");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.predmetService.deleteById(id);
        return "redirect:/predmet";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.predmetService.findById(id).isPresent()) {
            List<Profesor> profesors = this.profesorRepository.findAll();
            model.addAttribute("profesor", profesors);
            Predmet predmet = this.predmetService.findById(id).get();
            model.addAttribute("predmet", predmet);
            model.addAttribute("bodyContent", "add-predmet");
            return "master-template";
        }
        return "redirect:/predmet?error=UcenikNotFound";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Profesor> profesors = this.profesorRepository.findAll();
        model.addAttribute("profesor", profesors);
        model.addAttribute("bodyContent", "add-predmet");
        return "master-template";
    }
    @GetMapping("/details/{id}")
    public String addDetailsPage(Model model, @PathVariable Long id) {
        if (this.predmetService.findById(id).isPresent()) {
            Predmet predmet = this.predmetService.findById(id).get();
            model.addAttribute("predmet", predmet);
            model.addAttribute("bodyContent", "readmore-predmet");
            return "master-template";
        }
        return "redirect:/predmet?error=UcenikNotFound";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long id,
            @RequestParam String ime,
            @RequestParam List<Long> profesor,
            @RequestParam String vovedzapredmetot,
            @RequestParam String opis) {
        if (id != null) {
            this.predmetService.edit(id, ime, profesor, vovedzapredmetot, opis);
        } else {
            this.predmetService.save(ime, profesor, vovedzapredmetot, opis);
        }
        return "redirect:/predmet";
    }
}