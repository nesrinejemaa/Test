package com.example.test.controller;

import com.example.test.entity.Categorie;
import com.example.test.service.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping
    public Categorie creerCategorie(@RequestBody Categorie categorie) {
        return categorieService.creerCategorie(categorie);
    }

    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }
}
