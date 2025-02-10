package com.example.test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // Getters & Setters
}