package com.example.demo;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {
    private List<Tache> taches = new ArrayList<>();

    public List<Tache> getAllTaches() {
        return taches;
    }

    public Tache getTacheByTitre(String titre) {
        for (Tache tache : taches) {
            if (tache.getTitre().equals(titre)) {
                return tache;
            }
        }
        return null;
    }

    public void afficherListeTaches() {
        for (Tache tache : taches) {
            System.out.println(tache.getTitre());
        }
    }

    public void afficherTacheParNom(String titre) {
        Tache tache = getTacheByTitre(titre);
        if (tache != null) {
            System.out.println("Titre: " + tache.getTitre());
            System.out.println("Description: " + tache.getDescription());

            System.out.println("Complete : " + tache.estCompletee());
        } else {
            System.out.println("Tâche introuvable.");
        }
    }
}
