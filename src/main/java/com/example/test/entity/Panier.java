package com.example.test.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Panier {
    private List<Produit> produits = new ArrayList<>();

    public double getTotal() {
        return produits.stream().mapToDouble(p -> p.getPrix() * p.getQuantite()).sum();
    }
}
