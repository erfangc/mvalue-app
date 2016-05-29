package org.erfangc.mvalue.core.income;

import org.erfangc.mvalue.core.ValuationContext;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;

import static org.erfangc.mvalue.core.ValuationContext.calculateProceedsFromSale;

/**
 * {@link IncomeStatementCalculator}
 * Created by echen on 5/23/16.
 */
public class IncomeStatementCalculator {

    public IncomeStatementTimeSeries calculateIncomeStatements(PropertyAssumptions assumptions, MtgPmtTable pmtTable) {

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

    private IncomeStatementTimeSeries.IncomeStatement nextIncomeStatement(int period, IncomeStatementTimeSeries.IncomeStatement curr, ValuationContext ctx) {
        return new IncomeStatementTimeSeries.IncomeStatement()
                .period(period)
                .rent(ctx.getAssumptions().rent() * 12)
                .proceedsFromSale(ctx.getAssumptions().investmentHorizonInYrs() == period ? calculateProceedsFromSale(period, ctx) : 0)
                .interestExpense(ctx.getMtgPmtTable().getInterestExpense((period - 1) * 12 + 1, period * 12))
                .tax(ctx.getAssumptions().propertyTax() * 12)
                .commonCharges(ctx.getAssumptions().commonCharges() * 12)
                .closingCost(ctx.getAssumptions().investmentHorizonInYrs() == period ? ctx.getAssumptions().sellingClosingCost() : 0);
    }

}
