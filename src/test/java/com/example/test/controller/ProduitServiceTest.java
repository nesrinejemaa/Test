package com.example.test.controller;

import com.example.test.entity.Produit;
import com.example.test.repository.ProduitRepository;
import com.example.test.service.ProduitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitService produitService;

    @Test
    void testCreerProduit() {
        // Arrange
        Produit produit = new Produit();
        produit.setNom("iPhone 15");
        produit.setPrix(999.99);

        Mockito.when(produitRepository.save(Mockito.any(Produit.class))).thenReturn(produit);

        // Act
        Produit created = produitService.creerProduit(produit);

        // Assert
        assertNotNull(created);
        assertEquals("iPhone 15", created.getNom());
        assertEquals(999.99, created.getPrix());
    }

    @Test
    void testGetAllProduits() {
        // Arrange
        Produit produit1 = new Produit();
        produit1.setNom("Samsung Galaxy S23");

        Produit produit2 = new Produit();
        produit2.setNom("MacBook Pro");

        List<Produit> liste = Arrays.asList(produit1, produit2);
        Mockito.when(produitRepository.findAll()).thenReturn(liste);

        // Act
        List<Produit> result = produitService.getAllProduits();

        // Assert
        assertEquals(2, result.size());
    }
}
