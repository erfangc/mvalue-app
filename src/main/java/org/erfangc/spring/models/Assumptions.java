package org.erfangc.spring.models;

import org.erfangc.mvalue.core.IncomeStatementAssumptions;
import org.erfangc.mvalue.core.MtgAssumptions;

/**
 * Created by erfangchen on 5/28/16.
 */
public class Assumptions {
    private MtgAssumptions mtgAssumptions;
    private IncomeStatementAssumptions incomeStatementAssumptions;

    public MtgAssumptions getMtgAssumptions() {
        return mtgAssumptions;
    }

    public void setMtgAssumptions(MtgAssumptions mtgAssumptions) {
        this.mtgAssumptions = mtgAssumptions;
    }

    public IncomeStatementAssumptions getIncomeStatementAssumptions() {
        return incomeStatementAssumptions;
    }

    public void setIncomeStatementAssumptions(IncomeStatementAssumptions incomeStatementAssumptions) {
        this.incomeStatementAssumptions = incomeStatementAssumptions;
    }

    public Assumptions() {
    }

    public Assumptions(MtgAssumptions mtgAssumptions, IncomeStatementAssumptions incomeStatementAssumptions) {

        this.mtgAssumptions = mtgAssumptions;
        this.incomeStatementAssumptions = incomeStatementAssumptions;
    }
}
