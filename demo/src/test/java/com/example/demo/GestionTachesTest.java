package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// partie 1  
@SpringBootTest
public class GestionTachesTest {
    // @Autowired
    private GestionTaches gestionTaches = new GestionTaches();

    @Test
    public void testAjouter() {
        String title = "Tache 1";
        // ajouterTache return true if successs
        assertTrue(gestionTaches.ajouterTache(title, "Description de la Tache 1", 1));
        assertFalse(gestionTaches.ajouterTache(null, null, 0));
        // test Already Exist
        assertFalse(gestionTaches.ajouterTache(title, " test Already Exist", 7));
    }

    @Test
    public void testCompleterTacheExistante() {
        gestionTaches.ajouterTache("Tache 2", "Description de la Tache 2", 3);

        // set complet => if set is suc ==> true else ==> false
        assertTrue(gestionTaches.completerTache("Tache 2"));

        // test Completer Tache Inexistante
        assertFalse(gestionTaches.completerTache("Tache 404"));
    }

    // verification tests

    @Test
    public void testVerifierTacheExistanteNonCompletee() throws Exception {
        gestionTaches.ajouterTache("Tache 3", "Description de la Tache 3", 5);
        assertFalse(gestionTaches.verifierTache("Tache 3"));
    }

    @Test
    public void testVerifierTacheExistanteCompletee() throws Exception {
        gestionTaches.ajouterTache("Tache 4", "Description de la Tache 4", 6);
        gestionTaches.completerTache("Tache 4");
        assertTrue(gestionTaches.verifierTache("Tache 4"));
    }

    @Test
    public void testVerifierTacheInexistante() throws Exception {
        assertThrows(Exception.class, () -> gestionTaches.verifierTache("Tache 404 "));
    }
}
