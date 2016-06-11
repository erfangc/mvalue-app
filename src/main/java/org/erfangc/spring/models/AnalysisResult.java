package org.erfangc.spring.models;

import org.erfangc.mvalue.core.cf.CashflowStatement;
import org.erfangc.mvalue.core.income.IncomeStatement;
import org.erfangc.mvalue.core.mtg.MtgState;

import java.util.List;

/**
 * {@link AnalysisResult}
 * Created by erfangchen on 5/29/16.
 */
public class AnalysisResult {

    private List<IncomeStatement> incomeStatements;
    private List<CashflowStatement> cashflowStatements;
    private List<MtgState> mtgPmtTable;
    private double irr;

    public AnalysisResult(List<IncomeStatement> incomeStatements, List<CashflowStatement> cashflowStatements, List<MtgState> mtgPmtTable, double irr) {
        this.incomeStatements = incomeStatements;
        this.cashflowStatements = cashflowStatements;
        this.mtgPmtTable = mtgPmtTable;
        this.irr = irr;
    }

    public List<MtgState> getMtgPmtTable() {
        return mtgPmtTable;
    }

    public List<IncomeStatement> getIncomeStatements() {
        return incomeStatements;
    }

    public List<CashflowStatement> getCashflowStatements() {
        return cashflowStatements;
    }

    public double getIrr() {
        return irr;
    }
}
