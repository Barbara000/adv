package com.github.Barbara000.adv.logika;


import static com.github.Barbara000.adv.util.Texts.*;

/**
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv";
    private final HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude hledat aktuální místnost
     */
    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Promluví s herním objektem
     *
     * @param parametry - jako  parametr obsahuje jméno osoby,
     *                  se kterou má mluvit.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo , tak ....
            return tS_KYM_MLUVIT;
        }

        String jmenoVeci = parametry[0];
        // vybereme věc
        Vec vec = plan.getAktualniProstor().vyberVec(jmenoVeci, false);

        if (vec == null) {
            return tS_KYM_MLUVIT;
        }
        switch (parametry[0]) {
            case PRITEL:
                return oPRITEL;
            case VRATNY:
                return oVRATNY;
            default:
                return tNEODPOVI;

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

