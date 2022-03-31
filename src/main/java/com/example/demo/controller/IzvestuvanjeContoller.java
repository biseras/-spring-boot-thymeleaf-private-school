package com.example.demo.controller;

import com.example.demo.model.Izvestuvanje;
import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.service.IzvestuvanjeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/izvestuvanje")
public class IzvestuvanjeContoller {
    private final IzvestuvanjeService izvestuvanjeService;
    private final ProfesorRepository profesorRepository;

    public IzvestuvanjeContoller(IzvestuvanjeService izvestuvanjeService, ProfesorRepository profesorRepository) {
        this.izvestuvanjeService = izvestuvanjeService;
        this.profesorRepository = profesorRepository;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        // if (error != null && !error.isEmpty()) {
        ////   model.addAttribute("hasError", true);
        //    model.addAttribute("error", error);
        // }
        List<Izvestuvanje> izvestuvanjes = this.izvestuvanjeService.listAll();
        model.addAttribute("izvestuvanje", izvestuvanjes);
        model.addAttribute("bodyContent", "oglasnatabla");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.izvestuvanjeService.deleteById(id);
        return "redirect:/izvestuvanje";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.izvestuvanjeService.findById(id).isPresent()) {
            Izvestuvanje izvestuvanje = this.izvestuvanjeService.findById(id).get();
            List<Profesor> profesors = this.profesorRepository.findAll();
            model.addAttribute("profesor", profesors);
            model.addAttribute("izvestuvanje", izvestuvanje);
            model.addAttribute("bodyContent", "add-izvestuvanje");
            return "master-template";
        }
        return "redirect:/izvestuvanje?error=IzvestuvanjeNotFound";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Profesor> profesor = this.profesorRepository.findAll();
        model.addAttribute("profesor", profesor);
        model.addAttribute("bodyContent", "add-izvestuvanje");
        return "master-template";
    }
    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long id,
            @RequestParam String naslov,
            @RequestParam Long profesorId,
            @RequestParam String kategorija,
            @RequestParam String kratokvoved,
            @RequestParam String celoizvestuvanje) {
        if (id != null) {
            this.izvestuvanjeService.edit(id, naslov, profesorId, kategorija, kratokvoved, celoizvestuvanje);
        } else {
            this.izvestuvanjeService.save(naslov, profesorId, kategorija, kratokvoved, celoizvestuvanje);
        }
        return "redirect:/izvestuvanje";
    }
}
