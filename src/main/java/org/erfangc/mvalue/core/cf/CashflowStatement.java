package org.erfangc.mvalue.core.cf;

/**
 * {@link CashflowStatement}
 * Created by erfangchen on 5/29/16.
 */
public class CashflowStatement {

    private int period;

    public int getPeriod() {
        return period;
    }

    private double rent;
    private double proceedsFromSale;
    private double tax;
    private double commonCharges;
    private double mortgagePmt;
    private double downPayment;
    private double closingCost;

    public CashflowStatement rent(final double rent) {
        this.rent = rent;
        return this;
    }

    public CashflowStatement proceedsFromSale(final double proceedsFromSale) {
        this.proceedsFromSale = proceedsFromSale;
        return this;
    }

    public CashflowStatement tax(final double tax) {
        this.tax = tax;
        return this;
    }

    public CashflowStatement commonCharges(final double commonCharges) {
        this.commonCharges = commonCharges;
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
                    getTax() +
                    getClosingCost() +
                    getCommonCharges() +
                    getDownPayment() +
                    getMortgagePmt()
                );
    }

    public double getRent() {
        return rent;
    }

    public double getProceedsFromSale() {
        return proceedsFromSale;
    }

    public double getTax() {
        return tax;
    }

    public double getCommonCharges() {
        return commonCharges;
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

