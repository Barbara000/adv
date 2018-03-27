package com.github.Barbara000.adv.logika;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class ProstorTest {

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře,
     */
    @Test
    public void testLzeProjit() {
        Prostor prostor1 = new Prostor("koupelna", "sem se chodíš umývat");
        Prostor prostor2 = new Prostor("chodba", "chodba v bytě");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("chodba"));
        assertEquals(null, prostor2.vratSousedniProstor("zahrada"));
    }

}
