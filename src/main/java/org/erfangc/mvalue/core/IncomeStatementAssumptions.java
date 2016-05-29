package org.erfangc.mvalue.core;

/**
 * {@link IncomeStatementAssumptions}
 * Created by echen on 5/23/16.
 */
public class IncomeStatementAssumptions {

    private int investmentHorizonInYrs;
    private double cumulativeAppreciation;
    private double commonCharges;
    private double buyingClosingCost;
    private double sellingClosingCost;
    private double insurance;
    private double rent;
    private double propertyTax;

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getInvestmentHorizonInYrs() {
        return investmentHorizonInYrs;
    }

    public void setInvestmentHorizonInYrs(int investmentHorizonInYrs) {
        this.investmentHorizonInYrs = investmentHorizonInYrs;
    }

    public double getCumulativeAppreciation() {
        return cumulativeAppreciation;
    }

    public void setCumulativeAppreciation(double cumulativeAppreciation) {
        this.cumulativeAppreciation = cumulativeAppreciation;
    }

    public double getCommonCharges() {
        return commonCharges;
    }

    public void setCommonCharges(double commonCharges) {
        this.commonCharges = commonCharges;
    }

    public double getBuyingClosingCost() {
        return buyingClosingCost;
    }

    public void setBuyingClosingCost(double buyingClosingCost) {
        this.buyingClosingCost = buyingClosingCost;
    }

    public double getSellingClosingCost() {
        return sellingClosingCost;
    }

    public void setSellingClosingCost(double sellingClosingCost) {
        this.sellingClosingCost = sellingClosingCost;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(double propertyTax) {
        this.propertyTax = propertyTax;
    }

    public int investmentHorizonInYrs() {
        return this.investmentHorizonInYrs;
    }

    public double cumulativeAppreciation() {
        return this.cumulativeAppreciation;
    }

    public double commonCharges() {
        return this.commonCharges;
    }

    public double buyingClosingCost() {
        return this.buyingClosingCost;
    }

    public double sellingClosingCost() {
        return this.sellingClosingCost;
    }

    public double insurance() {
        return this.insurance;
    }

    public double propertyTax() {
        return this.propertyTax;
    }

    public IncomeStatementAssumptions investmentHorizonInYrs(final int investmentHorizonInYrs) {
        this.investmentHorizonInYrs = investmentHorizonInYrs;
        return this;
    }

    public IncomeStatementAssumptions cumulativeAppreciation(final double cumulativeAppreciation) {
        this.cumulativeAppreciation = cumulativeAppreciation;
        return this;
    }

    public IncomeStatementAssumptions commonCharges(final double commonCharges) {
        this.commonCharges = commonCharges;
        return this;
    }

    public IncomeStatementAssumptions buyingClosingCost(final double buyingClosingCost) {
        this.buyingClosingCost = buyingClosingCost;
        return this;
    }

    public IncomeStatementAssumptions sellingClosingCost(final double sellingClosingCost) {
        this.sellingClosingCost = sellingClosingCost;
        return this;
    }

    public IncomeStatementAssumptions insurance(final double insurance) {
        this.insurance = insurance;
        return this;
    }

    public IncomeStatementAssumptions propertyTax(final double propertyTax) {
        this.propertyTax = propertyTax;
        return this;
    }


    public double rent() {
        return this.rent;
    }

    public IncomeStatementAssumptions rent(final double rent) {
        this.rent = rent;
        return this;
    }
}