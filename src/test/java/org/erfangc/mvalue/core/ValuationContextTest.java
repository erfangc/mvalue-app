package org.erfangc.mvalue.core;

import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.mtg.MtgAssumptions;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link ValuationContextTest}
 * Created by erfangchen on 5/30/16.
 */
public class ValuationContextTest {
    @Test
    public void calculateGainsFromSale() throws Exception {
        ValuationContext ctx = new ValuationContext(
                new PropertyAssumptions().cumulativeAppreciation(0.2),
                new MtgPmtTable(0, new MtgAssumptions().homePrice(500000).ltv(0.8))
        );
        assertEquals(100000, ValuationContext.calculateGainsFromSale(ctx), 0.001);
    }

}