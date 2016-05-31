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

    /**
     * compute the leveraged return in dollar for sale of the house
     * @param ctx {@link ValuationContext}
     * @return gains from selling
     */
    public static double calculateGainsFromSale(ValuationContext ctx) {
        double homePrice = ctx.getMtgPmtTable().getAssumptions().getHomePrice();
        double appreciation = ctx.getAssumptions().getCumulativeAppreciation();
        return homePrice * appreciation;
    }

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
