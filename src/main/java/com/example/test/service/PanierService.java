package com.example.test.service;

import com.example.test.entity.Panier;
import com.example.test.entity.Produit;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PanierService {
    private final Panier panier = new Panier();

    public void ajouterProduit(Produit produit) {
        Optional<Produit> existing = panier.getProduits().stream()
                .filter(p -> p.getId().equals(produit.getId()))
                .findFirst();

        if (existing.isPresent()) {
            existing.get().setQuantite(existing.get().getQuantite() + produit.getQuantite());
        } else {
            panier.getProduits().add(produit);
        }
    }

    public void supprimerProduit(Long id) {
        panier.getProduits().removeIf(p -> p.getId().equals(id));
    }

    public void modifierQuantite(Long id, int nouvelleQuantite) {
        panier.getProduits().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .ifPresent(p -> p.setQuantite(nouvelleQuantite));
    }

    public Panier voirPanier() {
        return panier;
    }

    public double getTotal() {
        return panier.getTotal();
    }
}
