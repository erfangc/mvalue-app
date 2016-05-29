package org.erfangc.spring;

import org.erfangc.mvalue.core.IncomeStatementCalculator;
import org.erfangc.mvalue.core.IncomeStatementTimeSeries;
import org.erfangc.mvalue.core.MtgPmtTable;
import org.erfangc.mvalue.core.MtgPmtTableCalculator;
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

    @Autowired
    public APIController(IncomeStatementCalculator incomeStatementCalculator, MtgPmtTableCalculator mtgPmtTableCalculator) {
        this.incomeStatementCalculator = incomeStatementCalculator;
        this.mtgPmtTableCalculator = mtgPmtTableCalculator;
    }

    @RequestMapping(value = "analysis", method = RequestMethod.POST)
    public List<IncomeStatementTimeSeries.IncomeStatement> incomeStatementTimeSeries(@RequestBody Assumptions assumptions) {
        MtgPmtTable pmtTable = mtgPmtTableCalculator.calculateMtgPmt(assumptions.getMtgAssumptions());
        return incomeStatementCalculator.calculateIncomeStatements(assumptions.getIncomeStatementAssumptions(), pmtTable).toList();
    }
}
