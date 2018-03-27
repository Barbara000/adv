package com.github.Barbara000.adv.logika;

import static com.github.Barbara000.adv.util.Texts.*;

/**
 * Třída PrikazJdi implementuje pro hru příkaz jdi.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private final HerniPlan plan;
    private final Batoh batoh;

    /**
     * Konstruktor třídy
     *
     * @param plan  herní plán, ve kterém se bude ve hře "chodit"
     * @param batoh inventář hráče
     */
    public PrikazJdi(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }

    /**
     * Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     * existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     * (východ) není, vypíše se chybové hlášení.
     *
     * @param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                  do kterého se má jít.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Nevím,kam mám jít. Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam odsud jít nemůžeš!";
        } else {
            if (sousedniProstor.getNazev().equals(SCHODY) &&
                    (batoh.vyberVec(SVICKA, false) == null)) {
                return tNENI_SVETLO;
            }
            if (sousedniProstor.getNazev().equals(KONEC) &&
                    (batoh.vyberVec(OBLECENI, false) == null)) {
                return tNENI_OBLECENI;
            }

            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        }
    }

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
