package com.github.Barbara000.adv.logika;


import static com.github.Barbara000.adv.util.Texts.*;

/**
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class PrikazDej implements IPrikaz {
    private static final String NAZEV = "dej";

    private final Batoh batoh;
    private final Hra hra;

    /**
     * Konstruktor třídy
     * herní plán, ve kterém se bude hledat aktuální místnost
     * @param hra hra se kterou příkaz pracuje
     * @param batoh inventář hráče
     */
    public PrikazDej(Hra hra, Batoh batoh) {
        this.hra = hra;
        this.batoh = batoh;
    }

    /**
     * Provádí příkaz "dej". dá vybranou věc z batohu
     * vybranému hernímu objektu v prostoru
     *
     * @param parametry - jako  parametr obsahuje jméno věci,
     *                  která se má předat.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length < 2) {
            // pokud chybí druhé slovo , tak ....
            return tMALO_PARAMETRU;
        }

        HerniPlan plan = hra.getHerniPlan();
        String nazevCo = parametry[0];
        String nazevKam = parametry[1];

        // vybereme věc
        Vec vecBatoh = batoh.vyberVec(nazevCo, false);
        Vec vecProstoru = plan.getAktualniProstor().vyberVec(nazevKam, false);

        if (vecBatoh == null) {
            return tNENI_V_BATOHU;
        } else if (vecProstoru == null) {
            return tNENI_V_PROSTORU;
        }
        switch (vecProstoru.getNazev()) {
            case PRITEL:
                if (vecBatoh.getNazev().equals(SUSENKA)) {
                    batoh.vyberVec(SUSENKA, true);
                    batoh.vlozVec(new Vec(LIH, pLIH, true));
                    plan.getAktualniProstor().vyberVec(PRITEL, false).setPopis(pPRITEL2);
                    return tDOSTAL_LIH;
                } else {
                    return tNECHCE;
                }
            case VRATNY:
                if (vecBatoh.getNazev().equals(LIH)) {
                    batoh.vyberVec(LIH, true);
                    plan.getAktualniProstor().setVychod(new Prostor(KONEC, pKONEC));
                    plan.getAktualniProstor().vyberVec(VRATNY, false).setPopis(pVRATNY2);
                    return tVYCHOD;
                } else {
                    return tNECHCE;
                }
            default:
                return tNEJDE_DAT;
        }
    }

    /**
     * Vrací název příkazu
     *
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

