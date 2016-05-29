package org.erfangc.mvalue.core.mtg;

/**
 * {@link MtgState}
 * Created by erfangchen on 5/29/16.
 */
public class MtgState {

    public int getPeriod() {
        return period;
    }

    public double getBegBalance() {
        return begBalance;
    }

    public double getEndBalance() {
        return endBalance;
    }

    public double getInterestExpense() {
        return interestExpense;
    }

    public double getPrincipal() {
        return principal;
    }

    private int period;
    private double begBalance;
    private double endBalance;
    private double interestExpense;
    private double principal;

    public MtgState() {
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setBegBalance(double begBalance) {
        this.begBalance = begBalance;
    }

    public void setEndBalance(double endBalance) {
        this.endBalance = endBalance;
    }

    public void setInterestExpense(double interestExpense) {
        this.interestExpense = interestExpense;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public MtgState(int period, double begBalance, double endBalance, double interestExpense, double principal) {
        this.period = period;
        this.begBalance = begBalance;
        this.endBalance = endBalance;
        this.interestExpense = interestExpense;
        this.principal = principal;
    }
}
