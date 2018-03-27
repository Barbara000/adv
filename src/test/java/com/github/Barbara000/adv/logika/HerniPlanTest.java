package com.github.Barbara000.adv.logika;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Barbara Štruplová
 * @version 2017-05-09
 */
public class HerniPlanTest {
    private HerniPlan plan;

    @Before
    public void setUp() throws Exception {
        plan = new HerniPlan();
    }

    @Test
    public void setAktualniProstor() throws Exception {
        Prostor prostor = plan.getAktualniProstor().vratSousedniProstor("chodba");
        plan.setAktualniProstor(prostor);
        assertEquals(prostor, plan.getAktualniProstor());
    }

}