package org.erfangc.mvalue.core.cf;

import org.erfangc.mvalue.core.ValuationContext;
import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;

import static org.erfangc.mvalue.core.ValuationContext.calculateProceedsFromSale;

/**
 * {@link CashflowCaculator}
 * Created by erfangchen on 5/29/16.
 */
public class CashflowCaculator {

    public CashflowStatementTimeSeries calculateCashflowStatements(PropertyAssumptions assumptions, MtgPmtTable pmtTable) {
        int investHorizon = assumptions.getInvestmentHorizonInYrs();
        ValuationContext ctx = new ValuationContext(assumptions, pmtTable);
        CashflowStatement stmt = new CashflowStatement();
        stmt.period(1)
                .proceedsFromSale(0)
                .mortgagePmt(pmtTable.getPmt() * 12)
                .downPayment(pmtTable.getAssumptions().getHomePrice() * (1 - pmtTable.getAssumptions().getLtv()))
                .closingCost(assumptions.buyingClosingCost())
                .setCommonCharges(assumptions.commonCharges() * 12)
                .setPropertyTax(assumptions.propertyTax() * 12)
                .setRent(assumptions.rent() * 12);
        CashflowStatementTimeSeries ts = new CashflowStatementTimeSeries();
        for (int i = 1; i <= investHorizon; i++) {
            ts.add(stmt);
            stmt = nextCashflowStatement(i + 1, stmt, ctx);
        }
        return ts;
    }

    private CashflowStatement nextCashflowStatement(int i, CashflowStatement stmt, ValuationContext ctx) {
        CashflowStatement nextStmt = new CashflowStatement();
        double rent = stmt.getRent() * (1 + ctx.getPropertyAssumptions().getRentalIncrease());
        PropertyAssumptions assumptions = ctx.getPropertyAssumptions();
        MtgPmtTable pmtTable = ctx.getMtgPmtTable();
        nextStmt.period(i)
                .proceedsFromSale(assumptions.investmentHorizonInYrs() == i ? calculateProceedsFromSale(i, ctx) : 0.0)
                .mortgagePmt(pmtTable.getPmt() * 12)
                .downPayment(0.0)
                .closingCost(assumptions.investmentHorizonInYrs() == i ? assumptions.sellingClosingCost() : 0.0)
                .setCommonCharges(assumptions.commonCharges() * 12)
                .setPropertyTax(assumptions.propertyTax() * 12)
                .setRent(rent);

        return nextStmt;
    }

}
