package org.erfangc.mvalue.core.cf;

import org.erfangc.mvalue.core.FinancialStatement;

/**
 * {@link CashflowStatement}
 * Created by erfangchen on 5/29/16.
 */
public class CashflowStatement extends FinancialStatement {

    private int period;

    public int getPeriod() {
        return period;
    }

    private double proceedsFromSale;
    private double mortgagePmt;
    private double downPayment;
    private double closingCost;

    public CashflowStatement proceedsFromSale(final double proceedsFromSale) {
        this.proceedsFromSale = proceedsFromSale;
        return this;
    }

    public CashflowStatement mortgagePmt(final double mortgagePmt) {
        this.mortgagePmt = mortgagePmt;
        return this;
    }

    public CashflowStatement downPayment(final double downPayment) {
        this.downPayment = downPayment;
        return this;
    }

    public CashflowStatement closingCost(final double closingCost) {
        this.closingCost = closingCost;
        return this;
    }


    public double getNetCF() {
        return getRent() + getProceedsFromSale() -
                (
                    getPropertyTax() +
                    getClosingCost() +
                    getCommonCharges() +
                    getDownPayment() +
                    getMortgagePmt()
                );
    }

    public double getProceedsFromSale() {
        return proceedsFromSale;
    }

    public double getMortgagePmt() {
        return mortgagePmt;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public double getClosingCost() {
        return closingCost;
    }


    public CashflowStatement period(final int period) {
        this.period = period;
        return this;
    }
}

