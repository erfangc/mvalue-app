package org.erfangc.spring;

import org.erfangc.mvalue.core.cf.CashflowCaculator;
import org.erfangc.mvalue.core.cf.CashflowStatementTimeSeries;
import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.income.IncomeStatementCalculator;
import org.erfangc.mvalue.core.income.IncomeStatementTimeSeries;
import org.erfangc.mvalue.core.mtg.MtgPmtTable;
import org.erfangc.mvalue.core.mtg.MtgPmtTableCalculator;
import org.erfangc.spring.models.AnalysisResult;
import org.erfangc.spring.models.Assumptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@link APIController}
 * Created by erfangchen on 5/28/16.
 */
@CrossOrigin
@RestController
@RequestMapping("api")
public class APIController {

    private IncomeStatementCalculator incomeStatementCalculator;
    private MtgPmtTableCalculator mtgPmtTableCalculator;
    private CashflowCaculator cashflowCaculator;

    @Autowired
    public APIController(IncomeStatementCalculator incomeStatementCalculator, MtgPmtTableCalculator mtgPmtTableCalculator, CashflowCaculator cashflowCaculator) {
        this.incomeStatementCalculator = incomeStatementCalculator;
        this.mtgPmtTableCalculator = mtgPmtTableCalculator;
        this.cashflowCaculator = cashflowCaculator;
    }

    @RequestMapping(value = "analysis", method = RequestMethod.POST)
    public AnalysisResult incomeStatementTimeSeries(@RequestBody Assumptions assumptions) {
        MtgPmtTable pmtTable = mtgPmtTableCalculator.calculateMtgPmt(assumptions.getMtgAssumptions());
        PropertyAssumptions propertyAssumptions = assumptions.getPropertyAssumptions();
        List<IncomeStatementTimeSeries.IncomeStatement> incomeStatements = incomeStatementCalculator.calculateIncomeStatements(propertyAssumptions, pmtTable).toList();
        CashflowStatementTimeSeries cashflowStatementTimeSeries = cashflowCaculator.calculateCashflowStatements(propertyAssumptions, pmtTable);
        return new AnalysisResult(incomeStatements, cashflowStatementTimeSeries.toList(), cashflowStatementTimeSeries.getIRR());
    }
}
