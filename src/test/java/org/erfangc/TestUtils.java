package org.erfangc;

import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.mtg.MtgAssumptions;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;
import org.erfangc.mvalue.core.mtg.MtgPmtTableCalculator;

/**
 * {@link TestUtils}
 * Created by erfangchen on 5/29/16.
 */
public class TestUtils {
    public static PropertyAssumptions getDefaultIncomeStatementAssumptions() {
        return new PropertyAssumptions()
                .investmentHorizonInYrs(11)
                .rent(3000)
                .cumulativeAppreciation(0.2)
                .commonCharges(384)
                .buyingClosingCost(30000)
                .sellingClosingCost(42000)
                .insurance(0)
                .propertyTax(319);
    }

    public static MtgPmtTable getDefaultMtgPmtTable() {
        return new MtgPmtTableCalculator().calculateMtgPmt(new MtgAssumptions().homePrice(500000).ltv(0.8).nper(360).rate(0.04625));
    }
}
