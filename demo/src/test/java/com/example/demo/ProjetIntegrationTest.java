package com.example.demo;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProjetIntegrationTest {
    private GestionTaches gestionTaches = new GestionTaches();

    @Test
    public void testIntegration() throws Exception {

        var projet = new Projet("Projet 1");
        var tache = new Tache("Tache 1", "Description 1");

        assumeTrue(projet.ajouterTache(tache));
        assumeFalse(projet.ajouterTache(tache));

        assumeFalse(projet.ajouterTache(new Tache(null, null)));
    }

    // partie 3 calculerDureeTotaletest

    @Test

    public void testCalculerDureeTotale() throws Exception {
        var projet = new Projet("Projet 2");
        var tache1 = new Tache("Tache 1", "Description 1", 1);
        var tache2 = new Tache("Tache 2", "Description 2", 2);
        var tache3 = new Tache("Tache 3", "Description 3", 3);

        assumeTrue(projet.ajouterTache(tache1));
        assumeTrue(projet.ajouterTache(tache2));
        assumeTrue(projet.ajouterTache(tache3));

        assumeTrue(projet.calculerDureeTotale() == 6);

        assumeFalse(projet.calculerDureeTotale() == 7);
    }

    @Test
    public void testCalculerDureeTotaleWithEmptyList() throws Exception {
        var projet = new Projet("Projet 1");

        assertEquals(0, projet.calculerDureeTotale());
    }

    @Test
    public void testCalculerDureeTotaleWithNegativeDurations() throws Exception {
        var projet = new Projet("Projet 2");
        var tache1 = new Tache("Tache 1", "Description 1", -1);
        var tache2 = new Tache("Tache 2", "Description 2", -2);
        var tache3 = new Tache("Tache 3", "Description 3", -3);

        projet.ajouterTache(tache1);
        projet.ajouterTache(tache2);
        projet.ajouterTache(tache3);

        assertEquals(0, projet.calculerDureeTotale());
    }

}
