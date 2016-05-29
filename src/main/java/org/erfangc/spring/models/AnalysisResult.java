package org.erfangc.spring.models;

import org.erfangc.mvalue.core.cf.CashflowStatement;
import org.erfangc.mvalue.core.income.IncomeStatementTimeSeries;

import java.util.List;

/**
 * {@link AnalysisResult}
 * Created by erfangchen on 5/29/16.
 */
public class AnalysisResult {

    private List<IncomeStatementTimeSeries.IncomeStatement> incomeStatements;
    private List<CashflowStatement> cashflowStatements;
    private double irr;

    public AnalysisResult(List<IncomeStatementTimeSeries.IncomeStatement> incomeStatements, List<CashflowStatement> cashflowStatements, double irr) {
        this.incomeStatements = incomeStatements;
        this.cashflowStatements = cashflowStatements;
        this.irr = irr;
    }

    public List<IncomeStatementTimeSeries.IncomeStatement> getIncomeStatements() {
        return incomeStatements;
    }

    public List<CashflowStatement> getCashflowStatements() {
        return cashflowStatements;
    }

    public double getIrr() {
        return irr;
    }
}
