package org.erfangc.mvalue.core.income;

import org.erfangc.mvalue.core.FinancialStatement;

/**
 * {@link IncomeStatement}
 * Created by erfangchen on 6/11/16.
 */
public class IncomeStatement extends FinancialStatement {
    private double proceedsFromSale = 0;
    private double interestExpense = 0;
    private double closingCost = 0;

    public double totalRevenue() {
        return getRent() + this.proceedsFromSale;
    }

    public double totalExponses() {
        return this.interestExpense + getPropertyTax() + getCommonCharges() + this.closingCost;
    }

    public double netIncome() {
        return this.totalRevenue() - this.totalExponses();
    }

    public IncomeStatement proceedsFromSale(final double proceedsFromSale) {
        this.proceedsFromSale = proceedsFromSale;
        return this;
    }

    public IncomeStatement interestExpense(final double interestExpense) {
        this.interestExpense = interestExpense;
        return this;
    }

    public IncomeStatement closingCost(final double closingCost) {
        this.closingCost = closingCost;
        return this;
    }

    public double getProceedsFromSale() {
        return proceedsFromSale;
    }

    public double getTotalRevenue() {
        return totalRevenue();
    }


    public double getInterestExpense() {
        return interestExpense;
    }

    public double getClosingCost() {
        return closingCost;
    }

    public double getTotalExponses() {
        return totalExponses();
    }

    public double getNetIncome() {
        return netIncome();
    }

}
