package com.example.test.controller;


import com.example.test.entity.Panier;
import com.example.test.entity.Produit;
import com.example.test.service.PanierService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panier")
public class PanierController {
    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @PostMapping("/ajouter")
    public void ajouterProduit(@RequestBody Produit produit) {
        panierService.ajouterProduit(produit);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        panierService.supprimerProduit(id);
    }

    @PutMapping("/modifier/{id}/{quantite}")
    public void modifierQuantite(@PathVariable Long id, @PathVariable int quantite) {
        panierService.modifierQuantite(id, quantite);
    }

    @GetMapping
    public Panier voirPanier() {
        return panierService.voirPanier();
    }

    @GetMapping("/total")
    public double voirTotal() {
        return panierService.getTotal();
    }
}
