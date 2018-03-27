package com.github.Barbara000.adv.logika;


import java.util.Observable;
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
public class HerniPlan extends Observable{

    private Prostor aktualniProstor;
    private Hra hra;
    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Hra hra) {
        this.hra = hra;
        zalozProstoryHry();

    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor pokoj = new Prostor(POKOJ, pPOKOJ,80,0);
        Prostor chodba = new Prostor(CHODBA, pCHODBA,80,100);
        Prostor sklad = new Prostor(SKLAD, pSKLAD,0,100);
        Prostor soused = new Prostor(SOUSED, pSOUSED,150,50);
        Prostor vysetrovna = new Prostor(VYSETROVNA, pVYSETROVNA,150,140);
        Prostor sesterna = new Prostor(SESTERNA, pSESTERNA,230,140);
        Prostor schody = new Prostor(SCHODY, pSCHODY,80,200);


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
        pokoj.vlozVec(new Vec(SUSENKA, pSUSENKA, true,"susenka.jpg"));
        soused.vlozVec(new Vec(PRITEL, pPRITEL, false,"pritel.jpg"));
        sklad.vlozVec(new Vec(SVICKA, pSVICKA, true,"svicka.jpg"));
        sklad.vlozVec(new Vec(SKRIN, pSKRIN, false,"skrin.jpg"));
        vysetrovna.vlozVec(new Vec(OBLECENI, pOBLECENI, true,"obleceni.jpg"));
        schody.vlozVec(new Vec(VRATNY, pVRATNY, false,"vratny.jpg"));


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

    public Hra getHra() {
        return hra;
    }

    @Override
    public void notifyObservers(){
        setChanged();
        super.notifyObservers();
    }
    
}
