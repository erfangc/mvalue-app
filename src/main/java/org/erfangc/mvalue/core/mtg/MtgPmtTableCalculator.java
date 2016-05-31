package org.erfangc.mvalue.core.mtg;

import static java.lang.Math.pow;

/**
 * {@link MtgPmtTableCalculator}
 * Created by echen on 5/23/16.
 */
public class MtgPmtTableCalculator {

    public MtgPmtTable calculateMtgPmt(MtgAssumptions assumptions) {

        double i = assumptions.getRate() / 12;
        int n = assumptions.getNper();
        double annuityFactor = i + (i / (pow(1+i, n) - 1));
        double amtBorrowed = assumptions.getHomePrice() * assumptions.getLtv();
        double pmt = amtBorrowed * annuityFactor;
        MtgPmtTable tbl = new MtgPmtTable(pmt, assumptions);

        // keep track of current mtg state, update it throughout the loop
        double intExp = amtBorrowed * i;
        double prin = pmt - intExp;
        MtgState currentMtgState = new MtgState(1, amtBorrowed, amtBorrowed - prin, intExp, prin);
        for (int j = 1; j <= n; j++) {
            tbl.add(currentMtgState);
            // derive the next state, then set the current stage to next state
            double nextInterest = currentMtgState.getEndBalance() * i;
            double nextPrincipal = pmt - nextInterest;
            currentMtgState = new MtgState(j+1, currentMtgState.getEndBalance(), currentMtgState.getEndBalance() - nextPrincipal, nextInterest, nextPrincipal);
        }
        return tbl;
    }

}
