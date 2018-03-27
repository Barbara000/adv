package com.github.Barbara000.adv.logika;


import static com.github.Barbara000.adv.util.Texts.tNENI_CO_PROZKOUMAT;
import static com.github.Barbara000.adv.util.Texts.tVEC_NEZADANA;

/**
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class PrikazProzkoumej implements IPrikaz {
    private static final String NAZEV = "prozkoumej";
    private final HerniPlan plan;
    private final Batoh batoh;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude hledat aktuální místnost
     * @param batoh inventář hráče
     */
    public PrikazProzkoumej(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }

    /**
     * Provádí příkaz "prozkoumej". V prozkoumá zadanou věc
     *
     * @param parametry - jako  parametr obsahuje jméno věci,
     *                  která se má prozkoumat.
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
            vec = batoh.vyberVec(jmenoVeci, false);
            if (vec != null) {
                return vec.getPopis();
            }
            return tNENI_CO_PROZKOUMAT;
        } else {
            return vec.getPopis();
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

