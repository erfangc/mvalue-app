package org.erfangc.mvalue.core.cf;

import org.erfangc.mvalue.core.IRRCalc;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * {@link CashflowStatementTimeSeries}
 * Created by erfangchen on 5/29/16.
 */
public class CashflowStatementTimeSeries {

    private Map<Integer, CashflowStatement> cfTbl;

    public CashflowStatementTimeSeries() {
        this.cfTbl = cfTbl = new TreeMap<>();
    }

    public CashflowStatement getForPeriod(int i) {
        return this.cfTbl.get(i);
    }

    public void add(CashflowStatement stmt) {
        this.cfTbl.put(stmt.getPeriod(), stmt);
    }

    public Map<Integer, CashflowStatement> toMap() {
        return cfTbl;
    }

    public List<CashflowStatement> toList() {
        return cfTbl.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public double getIRR() {
        return IRRCalc.irr(toList().stream().mapToDouble(CashflowStatement::getNetCF).toArray());
    }
}
