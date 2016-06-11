package org.erfangc.mvalue.core.cf;

import org.erfangc.TestUtils;
import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link CashflowCaculatorTest}
 * Created by erfangchen on 5/29/16.
 */
public class CashflowCaculatorTest {

    @Test
    public void testCalculateCashflowStatements() throws Exception {

        CashflowCaculator obj = new CashflowCaculator();
        PropertyAssumptions propertyAssumptions = TestUtils.getDefaultIncomeStatementAssumptions();
        MtgPmtTable pmtTable = TestUtils.getDefaultMtgPmtTable();
        CashflowStatementTimeSeries ts = obj.calculateCashflowStatements(propertyAssumptions, pmtTable);
        assertEquals(-127114.70, ts.getForPeriod(1).getNetCF(), 0.01);
        assertEquals(249268.75, ts.getForPeriod(11).getNetCF(), 0.01);

        // test cash flow components
        CashflowStatement stmt = ts.getForPeriod(1);
        assertEquals(36000, stmt.getRent(), 0.01);
        assertEquals(0, stmt.getProceedsFromSale(), 0.01);
        assertEquals(3828.00, stmt.getPropertyTax(), 0.01);
        assertEquals(4608.00, stmt.getCommonCharges(), 0.01);
        assertEquals(24678.70, stmt.getMortgagePmt(), 0.01);
        assertEquals(100000.00, stmt.getDownPayment(), 0.01);
        assertEquals(30000.00, stmt.getClosingCost(), 0.01);

        // test IRR
        assertEquals(0.085727,ts.getIRR(),0.001);

    }
}