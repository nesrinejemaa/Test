package com.example.test.controller;

import com.example.test.entity.Categorie;
import com.example.test.service.CategorieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategorieController.class)
public class CategorieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CategorieService categorieService;

    @Test
    void testCreerCategorie() throws Exception {
        Categorie categorie = new Categorie();
        System.out.println("Catégorie créée: " + categorie); // Debug
        categorie.setNom("Électronique");

        Mockito.when(categorieService.creerCategorie(Mockito.any(Categorie.class))).thenReturn(categorie);

        mockMvc.perform(post("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\": \"Électronique\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Électronique"));
    }

    @Test
    void testGetAllCategories() throws Exception {
        Categorie categorie1 = new Categorie();
        categorie1.setNom("Informatique");

        Categorie categorie2 = new Categorie();
        categorie2.setNom("Téléphones");

        List<Categorie> liste = Arrays.asList(categorie1, categorie2);

        Mockito.when(categorieService.getAllCategories()).thenReturn(liste);

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
}

