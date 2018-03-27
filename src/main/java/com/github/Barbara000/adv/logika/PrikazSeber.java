package com.github.Barbara000.adv.logika;


import static com.github.Barbara000.adv.util.Texts.*;

/**
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private final HerniPlan plan;
    private final Batoh batoh;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude hledat aktuální místnost
     * @param batoh inventář hráče
     */
    public PrikazSeber(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }

    /**
     * Provádí příkaz "seber". V aktuální místnosti hledá věc, která je předána jako parametr
     *
     * @param parametry - jako  parametr obsahuje jméno věci,
     *                  která se má sebrat.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo , tak ....
            return tVEC_NEZADANA;
        }

        String jmenoVeci = parametry[0];

        // vybereme věc
        Vec vec = plan.getAktualniProstor().vyberVec(jmenoVeci, false);

        if (vec == null) {
            return tVEC_TU_NENI;
        } else {
            // uložíme věc do batohu
            return (vec.isPrenositelna() ? batoh.vlozVec(vec) : tNEMOHU_VZIT);
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

