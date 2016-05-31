package org.erfangc.mvalue.core.income;

import org.erfangc.TestUtils;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link IncomeStatementCalculatorTest}
 * Created by echen on 5/23/16.
 */
public class IncomeStatementCalculatorTest {

    @Test
    public void testCalculateIncomeStatements() throws Exception {

        IncomeStatementCalculator obj = new IncomeStatementCalculator();
        PropertyAssumptions propertyAssumptions = TestUtils.getDefaultIncomeStatementAssumptions();
        MtgPmtTable pmtTable = TestUtils.getDefaultMtgPmtTable();
        IncomeStatementTimeSeries ts = obj.calculateIncomeStatements(propertyAssumptions, pmtTable);
        assertEquals(-20803.33, ts.getForPeriod(1).getNetIncome(), 0.01);
        assertEquals(9494.84, ts.getForPeriod(2).getNetIncome(), 0.01);
        assertEquals(70899.0989691654, ts.getForPeriod(11).getNetIncome(), 0.01);

    }
}
