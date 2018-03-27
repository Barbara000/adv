package com.github.Barbara000.adv.logika;

import static com.github.Barbara000.adv.util.Texts.tPOMOC;

/**
 * Třída PrikazPomoc implementuje pro hru příkaz napoveda.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Barbaa Štruplová
 * @version 2017-05-09
 */
class PrikazPomoc implements IPrikaz {

    private static final String NAZEV = "pomoc";


    /**
     * Vrací nápovědu jak hru dohrát
     *
     * @return napoveda ke hre
     */
    @Override
    public String proved(String... parametry) {
        return tPOMOC;
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
