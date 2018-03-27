package com.github.Barbara000.adv.logika;

import static com.github.Barbara000.adv.util.Texts.tNAPOVEDA;

/**
 * Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
class PrikazNapoveda implements IPrikaz {

    private static final String NAZEV = "napoveda";
    private final SeznamPrikazu platnePrikazy;


    /**
     * Konstruktor třídy
     *
     * @param platnePrikazy seznam příkazů,
     *                      které je možné ve hře použít,
     *                      aby je nápověda mohla zobrazit uživateli.
     */
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    /**
     * Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     * vcelku primitivní zpráva a seznam dostupných příkazů.
     *
     * @return napoveda ke hre
     */
    @Override
    public String proved(String... parametry) {
        return tNAPOVEDA
                + "\n"
                + "Můžeš zadat tyto příkazy:\n"
                + platnePrikazy.vratNazvyPrikazu();
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
