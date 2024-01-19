package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private controller controller = new controller();

    @Test
    public void testGetAllTaches() {
        assertTrue(controller.getAllTaches().isEmpty());
    }

    @Test
    public void testGetTacheByTitre() {
        assertNull(controller.getTacheByTitre("nonexistent"));
    }

    @Test
    public void testGetTacheByTitreExisting() {
        Tache tache = new Tache("existent", "existent", 0);
        // tache.setTitre("existent");
        controller.getAllTaches().add(tache);
        assertEquals(tache, controller.getTacheByTitre("existent"));
    }

    // ...
}