package com.github.Barbara000.adv.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.github.Barbara000.adv.util.Texts.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class HraTest {
    private Hra hra1;

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }


    /***************************************************************************
     * Testuje průběh hry.
     *
     */
    @Test
    public void chyby() {
        assertEquals(tVEC_TU_NENI, this.hra1.zpracujPrikaz("seber kámen"));
        assertEquals(tVEC_NEZADANA, this.hra1.zpracujPrikaz("seber"));
        assertEquals(tMALO_PARAMETRU, this.hra1.zpracujPrikaz("dej"));
        assertEquals(tNENI_CO_PROZKOUMAT, this.hra1.zpracujPrikaz("prozkoumej kámen"));
        assertEquals(tS_KYM_MLUVIT, this.hra1.zpracujPrikaz("mluv kámen"));

        this.hra1.zpracujPrikaz("jdi chodba");

        assertEquals(tNENI_SVETLO, this.hra1.zpracujPrikaz("jdi schody"));

        this.hra1.zpracujPrikaz("jdi sklad");

        assertEquals(tNEMOHU_VZIT, this.hra1.zpracujPrikaz("seber skrin"));

        this.hra1.zpracujPrikaz("seber svicka");

        assertEquals(tNEJDE_DAT, this.hra1.zpracujPrikaz("dej svicka skrin"));

        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi soused");

        assertEquals(tNECHCE, this.hra1.zpracujPrikaz("dej svicka pritel"));
        assertEquals(tNENI_V_BATOHU, this.hra1.zpracujPrikaz("dej kámen pritel"));


    }


    @Test
    public void testVyhra() {
        this.hra1.zpracujPrikaz("seber susenka");
        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi soused");
        this.hra1.zpracujPrikaz("dej susenka pritel");
        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi sklad");
        this.hra1.zpracujPrikaz("seber svicka");
        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi vysetrovna");
        this.hra1.zpracujPrikaz("seber obleceni");
        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi schody");
        this.hra1.zpracujPrikaz("dej lih vratny");
        assertFalse(this.hra1.konecHry());
        assertEquals(this.hra1.getHerniPlan().getAktualniProstor()
                        .vratSousedniProstor(KONEC).dlouhyPopis(),
                this.hra1.zpracujPrikaz("jdi vychod"));
        assertTrue(this.hra1.konecHry());
        assertEquals(KONEC, this.hra1.getHerniPlan().getAktualniProstor().getNazev());
    }

    @Test
    public void testZabit() {
        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi vysetrovna");
        assertFalse(this.hra1.konecHry());
        assertEquals(this.hra1.getHerniPlan().getAktualniProstor()
                        .vratSousedniProstor(SESTERNA).dlouhyPopis(),
                this.hra1.zpracujPrikaz("jdi sesterna"));
        assertTrue(this.hra1.konecHry());
        assertEquals(SESTERNA, this.hra1.getHerniPlan().getAktualniProstor().getNazev());
    }
}
