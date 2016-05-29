package org.erfangc.mvalue.core;

import static java.text.MessageFormat.format;

/**
 * Created by echen on 5/23/16.
 */
public class MtgAssumptions {
    private int nper;
    private double rate;
    private double homePrice;
    private double ltv;

    @Override
    public String toString() {
        return format("# of Payment Period = {0}\nInterest Rate (Annualized) = {1}\nHome Price + {2}\bLoan-to-Value{3}", nper, rate, homePrice, ltv);
    }

    public MtgAssumptions nper(int nper) {
        this.nper = nper;
        return this;
    }

    public MtgAssumptions rate(double rate) {
        this.rate = rate;
        return this;
    }

    public MtgAssumptions homePrice(double homePrice) {
        this.homePrice = homePrice;
        return this;
    }

    public MtgAssumptions ltv(double ltv) {
        this.ltv = ltv;
        return this;
    }

    public int getNper() {
        return nper;
    }

    public double getRate() {
        return rate;
    }

    public double getHomePrice() {
        return homePrice;
    }

    public double getLtv() {
        return ltv;
    }
}
