package org.erfangc.mvalue.core;

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
        IncomeStatementAssumptions incomeStatementAssumptions = new IncomeStatementAssumptions()
                .investmentHorizonInYrs(11)
                .rent(3000)
                .cumulativeAppreciation(0.2)
                .commonCharges(384)
                .buyingClosingCost(30000)
                .sellingClosingCost(42000)
                .insurance(0)
                .propertyTax(319);

        MtgPmtTable pmtTable = new MtgPmtTableCalculator().calculateMtgPmt(new MtgAssumptions().homePrice(500000).ltv(0.8).nper(360).rate(0.04625));
        IncomeStatementTimeSeries ts = obj.calculateIncomeStatements(incomeStatementAssumptions, pmtTable);
        assertEquals(-20803.33, ts.getForPeriod(1).getNetIncome(), 0.01);
        assertEquals(9494.84, ts.getForPeriod(2).getNetIncome(), 0.01);
        assertEquals(259282.55, ts.getForPeriod(11).getNetIncome(), 0.01);

    }
}
