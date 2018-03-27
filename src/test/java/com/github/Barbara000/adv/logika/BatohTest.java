package com.github.Barbara000.adv.logika;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static com.github.Barbara000.adv.util.Texts.tNEMOHU_VZIT;
import static com.github.Barbara000.adv.util.Texts.tUSPESNE_VLOZENI;

/**
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class BatohTest {
    @Test
    public void vlozAVyberVec() throws Exception {
        Batoh batoh = new Batoh();
        Prostor prostor = new Prostor("TEST", "test");
        Vec testovaciVec = new Vec("vec", "nějaká věc", true);
        Vec testovaciVec2 = new Vec("balvan", "těžká věc", false);
        prostor.vlozVec(testovaciVec);
        prostor.vlozVec(testovaciVec2);

        assertEquals(tUSPESNE_VLOZENI, batoh.vlozVec(prostor.vyberVec("vec", true)));
        assertNull(prostor.vyberVec("vec", true));


        assertEquals(tNEMOHU_VZIT, batoh.vlozVec(testovaciVec2));
        assertEquals(testovaciVec2, prostor.vyberVec("balvan", false));

        assertEquals(testovaciVec, batoh.vyberVec("vec", false));
        assertEquals(testovaciVec, batoh.vyberVec("vec", true));
        assertNull(batoh.vyberVec("vec", true));
    }
}