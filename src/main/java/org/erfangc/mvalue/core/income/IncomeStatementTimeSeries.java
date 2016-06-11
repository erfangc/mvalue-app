package org.erfangc.mvalue.core.income;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * {@link IncomeStatementTimeSeries}
 * Created by echen on 5/23/16.
 */
public class IncomeStatementTimeSeries {

    public IncomeStatementTimeSeries() {
        this.isTbl = new TreeMap<>();
    }

    private Map<Integer, IncomeStatement> isTbl;

    public IncomeStatement getForPeriod(int period) {
        return isTbl.get(period);
    }

    public IncomeStatementTimeSeries add(IncomeStatement currentIncomeStatement) {
        isTbl.put(currentIncomeStatement.getPeriod(), currentIncomeStatement);
        return this;
    }

    public List<IncomeStatement> toList() {
        return this.isTbl.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }


}

