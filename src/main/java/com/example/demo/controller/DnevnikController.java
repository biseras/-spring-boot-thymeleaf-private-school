package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.DnevnikRepository;
import com.example.demo.repository.PredmetRepository;
import com.example.demo.repository.PredmetnaUcenikRepository;
import com.example.demo.service.DnevnikService;
import com.example.demo.service.UcenikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dnevnik")
public class DnevnikController {
    private final DnevnikService dnevnikService;
    private final DnevnikRepository dnevnikRepository;
    private final PredmetRepository predmetRepository;
    private final PredmetnaUcenikRepository predmetnaUcenikRepository;
    private final UcenikService ucenikService;

    public DnevnikController(DnevnikService dnevnikService, DnevnikRepository dnevnikRepository, PredmetRepository predmetRepository, PredmetnaUcenikRepository predmetnaUcenikRepository, UcenikService ucenikService) {
        this.dnevnikService = dnevnikService;
        this.dnevnikRepository = dnevnikRepository;
        this.predmetRepository = predmetRepository;
        this.predmetnaUcenikRepository = predmetnaUcenikRepository;
        this.ucenikService = ucenikService;
    }

    @GetMapping
    public String getDnevnikPage(@RequestParam(required = false) String error, Model model) {
        // if (error != null && !error.isEmpty()) {
        ////   model.addAttribute("hasError", true);
        //    model.addAttribute("error", error);
        // }
        List<Dnevnik> dnevniks = this.dnevnikService.listAll();
        List<PredmetnaUcenik> predmet = this.predmetnaUcenikRepository.findAll();
        List<Ucenik> uceniks = this.ucenikService.listAll();
        model.addAttribute("predmet", predmet);
        model.addAttribute("ucenik", uceniks);
        model.addAttribute("dnevnik", dnevniks);
        model.addAttribute("bodyContent", "dnevnik");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.dnevnikService.deleteById(id);
        return "redirect:/dnevnik";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.ucenikService.findById(id).isPresent()) {
            Ucenik ucenik = this.ucenikService.findById(id).get();
            List<Predmet> predmet = this.predmetRepository.findAll();
            model.addAttribute("predmet", predmet);
            model.addAttribute("ucenik", ucenik);
            model.addAttribute("bodyContent", "add-dnevnik");
            return "master-template";
        }
        return "redirect:/uceniks?error=UcenikNotFound";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Predmet> predmets = this.predmetRepository.findAll();
        List<Ucenik> uceniks=this.ucenikService.listAll();
        model.addAttribute("predmet", predmets);
        model.addAttribute("ucenik", uceniks);
        model.addAttribute("bodyContent", "add-dnevnik");
        return "master-template";
    }

//    @PostMapping("/add")
//    public String saveProduct(
//            @RequestParam(required = false) Long id,
//            @RequestParam Long ucenik,
//            @RequestParam Long predmet1,
//            @RequestParam(required = false) Integer ocenka1,
//            @RequestParam Long predmet2,
//            @RequestParam(required = false) Integer ocenka2,
//            @RequestParam Long predmet3,
//            @RequestParam(required = false) Integer ocenka3,
//            @RequestParam Long predmet4,
//            @RequestParam(required = false) Integer ocenka4,
//            @RequestParam Long predmet5,
//            @RequestParam(required = false) Integer ocenka5) {
//        if (id != null) {
//            this.dnevnikService.edit(Long id, String ime, String prezime, String datum, String adresa, String email, Long predmetId1, Integer ocenka1, Long predmetId2, Integer ocenka2, Long predmetId3, Integer ocenka3, Long predmetId4, Integer ocenka4, Long predmetId5, Integer ocenka5);
//        } else {
//            //this.dnevnikService.save(ucenik, predmet1, ocenka1, predmet2, ocenka2, predmet3, ocenka3, predmet4, ocenka4, predmet5, ocenka5);
//        }
//        return "redirect:/dnevnik";
//    }
}
