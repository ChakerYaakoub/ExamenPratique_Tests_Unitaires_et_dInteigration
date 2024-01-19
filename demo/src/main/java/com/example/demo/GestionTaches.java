package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GestionTaches {
    // create la list de taches
    private List<Tache> taches;

    public GestionTaches() {
        taches = new ArrayList<>();
    }

    public boolean ajouterTache(String titre, String description, int duration) {

        if (titre == null || description == null || duration < 0) {
            return false;
        }
        for (Tache tache : taches) {
            // if title == tilte then set complet false ==> already exist
            if (tache.getTitre().equals(titre)) {

                return false;
            }
        }
        Tache nouvelleTache = new Tache(titre, description, duration);

        taches.add(nouvelleTache);

        // succ
        return true;

    }

    public boolean completerTache(String titre) {
        for (Tache tache : taches) {
            // if title == tilte then set complet true
            if (tache.getTitre().equals(titre)) {
                tache.setCompletee(true);
                // Tâche trouvée et complétée avec succès
                return true;
            }
        }
        // Tâche non trouvée
        return false;
    }

    public boolean verifierTache(String titre) throws Exception {
        for (Tache tache : taches) {
            if (tache.getTitre().equals(titre)) {
                // Retourne true si la tâche est complétée, false sinon
                return tache.estCompletee();
            }
        }
        // Tâche non trouvée == > Exeption
        throw new Exception("Tâche non trouvée");
        // return false;
    }

}
