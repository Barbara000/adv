package com.github.Barbara000.adv.logika;

import static com.github.Barbara000.adv.util.Texts.*;

/**
 * Class HerniPlan - třída představující mapu a stav adventury.
 * <p>
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory,
 * propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class HerniPlan {

    private Prostor aktualniProstor;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor pokoj = new Prostor(POKOJ, pPOKOJ);
        Prostor chodba = new Prostor(CHODBA, pCHODBA);
        Prostor sklad = new Prostor(SKLAD, pSKLAD);
        Prostor soused = new Prostor(SOUSED, pSOUSED);
        Prostor vysetrovna = new Prostor(VYSETROVNA, pVYSETROVNA);
        Prostor sesterna = new Prostor(SESTERNA, pSESTERNA);
        Prostor schody = new Prostor(SCHODY, pSCHODY);


        // přiřazují se průchody mezi prostory (sousedící prostory)
        pokoj.setVychod(chodba);
        sklad.setVychod(chodba);
        soused.setVychod(chodba);
        chodba.setVychod(pokoj);
        chodba.setVychod(soused);
        chodba.setVychod(sklad);
        chodba.setVychod(schody);
        chodba.setVychod(vysetrovna);
        vysetrovna.setVychod(chodba);
        vysetrovna.setVychod(sesterna);
        schody.setVychod(chodba);


        // umístíme věci do světa
        pokoj.vlozVec(new Vec(SUSENKA, pSUSENKA, true));
        soused.vlozVec(new Vec(PRITEL, pPRITEL, false));
        sklad.vlozVec(new Vec(SVICKA, pSVICKA, true));
        sklad.vlozVec(new Vec(SKRIN, pSKRIN, false));
        vysetrovna.vlozVec(new Vec(OBLECENI, pOBLECENI, true));
        schody.vlozVec(new Vec(VRATNY, pVRATNY, false));


        aktualniProstor = pokoj;  // hra začíná ve tvém pokoji
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }


}
