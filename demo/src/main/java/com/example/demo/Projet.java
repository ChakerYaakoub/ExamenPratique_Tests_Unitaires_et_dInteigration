package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

public class Projet {
    private String nom;
    private List<Tache> taches;
    private GestionTaches gestionTaches;

    public Projet(String nom) throws Exception {
        if (nom == null)
            throw new Exception("nom ou gestionTaches null");
        this.nom = nom;
        this.taches = new ArrayList<>();
        this.gestionTaches = new GestionTaches();
    }

    public String getNom() {
        return nom;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public boolean ajouterTache(Tache tache) {
        if (gestionTaches.ajouterTache(tache.getTitre(), tache.getDescription(), tache.duration())) {
            taches.add(tache);
            return true;
        }
        return false;
    }

    public boolean ajouterTaches(List<Tache> nouvellesTaches) {
        for (Tache tache : nouvellesTaches) {
            if (!ajouterTache(tache))
                return false;
        }

        return true;
    }

    public int calculerDureeTotale() {
        int dureeTotale = 0;
        for (Tache tache : taches) {
            dureeTotale += tache.duration();
        }
        return dureeTotale;
    }
}
