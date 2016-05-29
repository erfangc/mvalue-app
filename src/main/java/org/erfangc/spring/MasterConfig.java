package org.erfangc.spring;

import org.erfangc.mvalue.core.cf.CashflowCaculator;
import org.erfangc.mvalue.core.income.IncomeStatementCalculator;
import org.erfangc.mvalue.core.mtg.MtgPmtTableCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link MasterConfig}
 * Created by erfangchen on 5/28/16.
 */
@Configuration
public class MasterConfig {

    @Bean
    public IncomeStatementCalculator incomeStatementCalculator() {
        return new IncomeStatementCalculator();
    }

    @Bean
    public MtgPmtTableCalculator mtgPmtTableCalculator() {
        return new MtgPmtTableCalculator();
    }

    @Bean
    public CashflowCaculator cashflowCaculator() {
        return new CashflowCaculator();
    }

}
