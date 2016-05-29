package org.erfangc.mvalue.core;

import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;

/**
 * {@link ValuationContext}
 * Created by erfangchen on 5/29/16.
 */
public class ValuationContext {
    private PropertyAssumptions assumptions;

    public MtgPmtTable getMtgPmtTable() {
        return mtgPmtTable;
    }

    public PropertyAssumptions getAssumptions() {
        return assumptions;
    }

    private MtgPmtTable mtgPmtTable;

    public static double calculateProceedsFromSale(int period, ValuationContext ctx) {
        double remainingMtgBalance = ctx.getMtgPmtTable().getEndingBalance(period * 12);
        double sellPrice = ctx.getMtgPmtTable().getAssumptions().getHomePrice() * (1 + ctx.getAssumptions().cumulativeAppreciation());
        return sellPrice - remainingMtgBalance;
    }

    public ValuationContext(PropertyAssumptions assumptions, MtgPmtTable mtgPmtTable) {
        this.assumptions = assumptions;
        this.mtgPmtTable = mtgPmtTable;
    }
}
