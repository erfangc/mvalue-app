package org.erfangc.mvalue.core.mtg;

/**
 * Created by echen on 5/23/16.
 */
public class MtgAssumptions {
    private int nper;
    private double rate;
    private double homePrice;
    private double ltv;

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
