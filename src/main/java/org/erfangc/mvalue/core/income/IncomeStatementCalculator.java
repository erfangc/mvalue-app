package org.erfangc.mvalue.core.income;

import org.erfangc.mvalue.core.ValuationContext;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;

import static org.erfangc.mvalue.core.ValuationContext.calculateGainsFromSale;

/**
 * {@link IncomeStatementCalculator}
 * Created by echen on 5/23/16.
 */
public class IncomeStatementCalculator {

    public IncomeStatementTimeSeries calculateIncomeStatements(PropertyAssumptions assumptions, MtgPmtTable pmtTable) {

        int investHorizon = assumptions.investmentHorizonInYrs();

        IncomeStatement currentIncomeStatement = new IncomeStatement();
        currentIncomeStatement.proceedsFromSale(0)
                .interestExpense(pmtTable.getInterestExpense(1, 12))
                .closingCost(assumptions.buyingClosingCost())
                .setPeriod(1)
                .setRent(assumptions.rent() * 12)
                .setPropertyTax(assumptions.propertyTax() * 12)
                .setCommonCharges(assumptions.commonCharges() * 12);

        IncomeStatementTimeSeries ts = new IncomeStatementTimeSeries();
        ValuationContext ctx = new ValuationContext(assumptions, pmtTable);
        for (int i = 1; i <= investHorizon; i++) {
            ts.add(currentIncomeStatement);
            currentIncomeStatement = nextIncomeStatement(i + 1, currentIncomeStatement, ctx);
        }
        return ts;
    }

    private IncomeStatement nextIncomeStatement(int period, IncomeStatement curr, ValuationContext ctx) {
        // rental growth is a function of appreciation I assume
        double rent = curr.getRent() * (1 + ctx.getPropertyAssumptions().getRentalIncrease());
        IncomeStatement incomeStatement = new IncomeStatement();
        incomeStatement
                .proceedsFromSale(ctx.getPropertyAssumptions().investmentHorizonInYrs() == period ? calculateGainsFromSale(ctx) : 0)
                .interestExpense(ctx.getMtgPmtTable().getInterestExpense((period - 1) * 12 + 1, period * 12))
                .closingCost(ctx.getPropertyAssumptions().investmentHorizonInYrs() == period ? ctx.getPropertyAssumptions().sellingClosingCost() : 0)
                .setPropertyTax(ctx.getPropertyAssumptions().propertyTax() * 12)
                .setCommonCharges(ctx.getPropertyAssumptions().commonCharges() * 12)
                .setPeriod(period)
                .setRent(rent);
        return incomeStatement;
    }

}
