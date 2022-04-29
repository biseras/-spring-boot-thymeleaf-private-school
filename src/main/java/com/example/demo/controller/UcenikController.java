package com.example.demo.controller;

import com.example.demo.model.Predmet;
import com.example.demo.model.Ucenik;
import com.example.demo.repository.PredmetRepository;
import com.example.demo.service.UcenikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ucenik")
public class UcenikController {
    private final UcenikService ucenikService;
    private final PredmetRepository predmetRepository;

    public UcenikController(UcenikService ucenikService, PredmetRepository predmetRepository) {
        this.ucenikService = ucenikService;
        this.predmetRepository = predmetRepository;
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
            List<Predmet> predmet = this.predmetRepository.findAll();
            model.addAttribute("predmet", predmet);
            model.addAttribute("ucenik", ucenik);
            model.addAttribute("bodyContent", "add-ucenik");
            return "master-template";
        }
        return "redirect:/uceniks?error=UcenikNotFound";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Predmet> predmet = this.predmetRepository.findAll();
        model.addAttribute("predmet", predmet);
        model.addAttribute("bodyContent", "add-ucenik");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveUcenik(
            @RequestParam(required = false) Long id,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String datum,
            @RequestParam String adresa,
            @RequestParam String email,
            @RequestParam Long predmet1,
            @RequestParam(required = false) Integer ocenka1,
            @RequestParam Long predmet2,
            @RequestParam(required = false) Integer ocenka2,
            @RequestParam Long predmet3,
            @RequestParam(required = false) Integer ocenka3,
            @RequestParam Long predmet4,
            @RequestParam(required = false) Integer ocenka4,
            @RequestParam Long predmet5,
            @RequestParam(required = false) Integer ocenka5) {
        if (id != null) {
            //this.ucenikService.edit(id, ime, prezime, datum, adresa, email, predmet1, ocenka1, predmet2, ocenka2, predmet3, ocenka3, predmet4, ocenka4, predmet5, ocenka5);
        } else {
            this.ucenikService.save(ime, prezime, datum, adresa, email, predmet1, ocenka1, predmet2, ocenka2, predmet3, ocenka3, predmet4, ocenka4, predmet5, ocenka5);
        }
        return "redirect:/ucenik";
    }
}
