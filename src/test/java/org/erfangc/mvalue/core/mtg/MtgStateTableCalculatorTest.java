package org.erfangc.mvalue.core.mtg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link MtgStateTableCalculatorTest}
 * Created by echen on 5/23/16.
 */
public class MtgStateTableCalculatorTest {
    @Test
    public void testCalculateMtgPmt() throws Exception {
        MtgPmtTable tbl = getMtgPmtTable();
        assertEquals(2056.56, tbl.getPmt(), 0.01);
        assertEquals(18367.33, tbl.getInterestExpense(1, 12), 0.01);
        assertEquals(393688.63, tbl.getEndingBalance(12), 0.01);
        assertEquals(0.0, tbl.getEndingBalance(360), 0.01);
    }

    @Test
    public void testGetInterestExpenseOutOfBoundsAccess() {
        MtgPmtTable tbl = getMtgPmtTable();
        assertEquals(0, tbl.getInterestExpense(0, 361), 0.001);
    }

    @Test
    public void testGetInterestExpenseOutOfBoundsAccess1() {
        MtgPmtTable tbl = getMtgPmtTable();
        assertEquals(0, tbl.getInterestExpense(-1, 350), 0.001);
    }

    @Test
    public void testGetEndingBalanceOutOfBoundsAccess1() {
        MtgPmtTable tbl = getMtgPmtTable();
        assertEquals(0, tbl.getEndingBalance(361), 0.001);
    }

    private MtgPmtTable getMtgPmtTable() {
        MtgPmtTableCalculator obj = new MtgPmtTableCalculator();
        MtgAssumptions mtgAssumptions = new MtgAssumptions().nper(360).rate(.04625).ltv(0.8).homePrice(500000.00);
        return obj.calculateMtgPmt(mtgAssumptions);
    }

}
