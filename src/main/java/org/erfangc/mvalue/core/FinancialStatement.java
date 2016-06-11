package org.erfangc.mvalue.core;

import org.erfangc.mvalue.core.income.IncomeStatement;

/**
 * Base class for {@link IncomeStatement} and {@link org.erfangc.mvalue.core.cf.CashflowStatement}
 * Created by erfangchen on 6/10/16.
 */
public class FinancialStatement {
    private int period;
    private double rent;
    private double commonCharges;
    private double propertyTax;

    public int getPeriod() {
        return period;
    }

    public FinancialStatement setPeriod(final int period) {
        this.period = period;
        return this;
    }

    public double getRent() {
        return rent;
    }

    public FinancialStatement setRent(final double rent) {
        this.rent = rent;
        return this;
    }

    public double getCommonCharges() {
        return commonCharges;
    }

    public FinancialStatement setCommonCharges(final double commonCharges) {
        this.commonCharges = commonCharges;
        return this;
    }

    public double getPropertyTax() {
        return propertyTax;
    }

    public FinancialStatement setPropertyTax(final double propertyTax) {
        this.propertyTax = propertyTax;
        return this;
    }

}

