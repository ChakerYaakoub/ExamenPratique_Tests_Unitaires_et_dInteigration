package com.example.demo;

public class Tache {

    private String titre;
    private String description;
    private boolean completee;
    private int duration;

    public Tache(String titre, String description, int duration) {
        this.titre = titre;
        this.description = description;
        this.completee = false;
        this.duration = duration;
    }

    public Tache(String titre, String description) {
        this(titre, description, 0);
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public boolean estCompletee() {
        return completee;
    }

    public void setCompletee(boolean completee) {
        this.completee = completee;
    }

    public int duration() {
        return this.duration;
    }
}
