package com.github.Barbara000.adv.logika;


import java.util.HashMap;
import java.util.Map;

import static com.github.Barbara000.adv.util.Texts.*;

/**
 * Trida Batoh
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */

class Batoh {
    private static final int KAPACITA = 3;
    private final Map<String, Vec> seznamVeci;   // seznam věcí v batohu

    public Batoh() {
        seznamVeci = new HashMap<>();
    }

    /**
     * Vloží věc do batohu
     *
     * @param vec instance věci, která se má vložit
     */
    public String vlozVec(Vec vec) {
        if (!vec.isPrenositelna()) {
            return tNEMOHU_VZIT;
        }
        if (seznamVeci.size() < KAPACITA) {
            seznamVeci.put(vec.getNazev(), vec);
            return tUSPESNE_VLOZENI;
        }
        return tNEUSPESNE_VLOZENI;
    }

    /**
     * Vrací řetězec názvů věcí, které jsou v batohu
     *
     * @return řetězec názvů
     */
    public String nazvyVeci() {
        String nazvy = "věci v batohu: ";
        for (String jmenoVeci : seznamVeci.keySet()) {
            nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }


    /**
     * Hledá věc daného jména a pokud je v batohu, tak ji vrátí a vymaže ze seznamu
     *
     * @param jmeno Jméno věci
     * @return věc nebo hodnota null, pokud tam věc daného jména není
     */
    public Vec vyberVec(String jmeno, boolean odebrat) {
        Vec nalezenaVec = null;
        if (seznamVeci.containsKey(jmeno)) {
            nalezenaVec = seznamVeci.get(jmeno);
            if (odebrat) {
                seznamVeci.remove(jmeno);
            }
        }
        return nalezenaVec;
    }

}



