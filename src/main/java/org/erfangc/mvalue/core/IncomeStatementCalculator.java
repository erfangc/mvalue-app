package org.erfangc.mvalue.core;

/**
 * {@link IncomeStatementCalculator}
 * Created by echen on 5/23/16.
 */
public class IncomeStatementCalculator {

    public IncomeStatementTimeSeries calculateIncomeStatements(IncomeStatementAssumptions assumptions, MtgPmtTable pmtTable) {

        int investHorizon = assumptions.investmentHorizonInYrs();

        IncomeStatementTimeSeries.IncomeStatement currentIncomeStatement = new IncomeStatementTimeSeries.IncomeStatement()
                .period(1)
                .rent(assumptions.rent() * 12)
                .proceedsFromSale(0)
                .interestExpense(pmtTable.getInterestExpense(1, 12))
                .tax(assumptions.propertyTax() * 12)
                .commonCharges(assumptions.commonCharges() * 12)
                .closingCost(assumptions.buyingClosingCost());

        IncomeStatementTimeSeries ts = new IncomeStatementTimeSeries();
        ValuationContext ctx = new ValuationContext(assumptions, pmtTable);
        for (int i = 1; i <= investHorizon; i++) {
            ts.add(currentIncomeStatement);
            currentIncomeStatement = nextIncomeStatement(i + 1, currentIncomeStatement, ctx);
        }
        return ts;
    }

    private static class ValuationContext {
        IncomeStatementAssumptions assumptions;
        MtgPmtTable mtgPmtTable;

        ValuationContext(IncomeStatementAssumptions assumptions, MtgPmtTable mtgPmtTable) {
            this.assumptions = assumptions;
            this.mtgPmtTable = mtgPmtTable;
        }
    }

    private IncomeStatementTimeSeries.IncomeStatement nextIncomeStatement(int period, IncomeStatementTimeSeries.IncomeStatement curr, ValuationContext ctx) {
        return new IncomeStatementTimeSeries.IncomeStatement()
                .period(period)
                .rent(ctx.assumptions.rent() * 12)
                .proceedsFromSale(ctx.assumptions.investmentHorizonInYrs() == period ? calculateProceedsFromSale(period, ctx) : 0)
                .interestExpense(ctx.mtgPmtTable.getInterestExpense((period - 1) * 12 + 1, period * 12))
                .tax(ctx.assumptions.propertyTax() * 12)
                .commonCharges(ctx.assumptions.commonCharges() * 12)
                .closingCost(ctx.assumptions.investmentHorizonInYrs() == period ? ctx.assumptions.sellingClosingCost() : 0);
    }

    private double calculateProceedsFromSale(int period, ValuationContext ctx) {
        double remainingMtgBalance = ctx.mtgPmtTable.getEndingBalance(period * 12);
        double sellPrice = ctx.mtgPmtTable.getAssumptions().getHomePrice() * (1 + ctx.assumptions.cumulativeAppreciation());
        return sellPrice - remainingMtgBalance;
    }

}
