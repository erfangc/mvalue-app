package org.erfangc.mvalue.core.mtg;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

/**
 * {@link MtgPmtTable}
 * Created by echen on 5/23/16.
 */
public class MtgPmtTable {

    private Map<Integer, MtgState> pmtTbl;
    private double pmt;
    private MtgAssumptions assumptions;

    public MtgAssumptions getAssumptions() {
        return assumptions;
    }

    public MtgPmtTable(int nper, double pmt, MtgAssumptions assumptions) {
        pmtTbl = new TreeMap<>();
        this.pmt = pmt;
        this.assumptions = assumptions;
    }

    public MtgPmtTable add(MtgState mtgState) {
        pmtTbl.put(mtgState.getPeriod(), mtgState);
        return this;
    }

    public double getPmt() {
        return pmt;
    }

    public double getInterestExpense(int periodStart, int periodEnd) {
        double intExp = 0.0;
        if (periodStart < 1 || periodEnd > pmtTbl.size())
            throw new IllegalArgumentException(format("period less than 1 or greater than {}", pmtTbl.size()));
        for (int i = periodStart; i <= periodEnd; i++)
            intExp += pmtTbl.get(i).getInterestExpense();
        return intExp;
    }

    public double getEndingBalance(int period) {
        if (period > pmtTbl.size())
            throw new IllegalArgumentException(format("period cannot be greater than {}", pmtTbl.size()));
        return pmtTbl.get(period).getEndBalance();
    }

    public List<MtgState> toList() {
        return pmtTbl.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

}
