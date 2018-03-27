/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.Barbara000.adv.main;


import com.github.Barbara000.adv.logika.Hra;
import com.github.Barbara000.adv.logika.IHra;
import com.github.Barbara000.adv.tui.TextoveRozhrani;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
final class Start {
    private Start() {
    }

    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args) {
        IHra hra = new Hra();
        TextoveRozhrani tui = new TextoveRozhrani(hra);
        tui.hraj();
    }
}
