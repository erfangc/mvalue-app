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
        isTbl.put(currentIncomeStatement.period, currentIncomeStatement);
        return this;
    }

    public List<IncomeStatement> toList() {
        return this.isTbl.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }


    public static class IncomeStatement {
        public int getPeriod() {
            return period;
        }

        private int period;
        private double rent = 0, proceedsFromSale = 0;
        private double interestExpense = 0, tax = 0, commonCharges = 0, closingCost = 0;

        public double totalRevenue() {
            return this.rent + this.proceedsFromSale;
        }

        public double totalExponses() {
            return this.interestExpense + this.tax + this.commonCharges + this.closingCost;
        }

        public double netIncome() {
            return this.totalRevenue() - this.totalExponses();
        }

        public IncomeStatement rent(final double rent) {
            this.rent = rent;
            return this;
        }

        public IncomeStatement proceedsFromSale(final double proceedsFromSale) {
            this.proceedsFromSale = proceedsFromSale;
            return this;
        }

        public IncomeStatement interestExpense(final double interestExpense) {
            this.interestExpense = interestExpense;
            return this;
        }

        public IncomeStatement tax(final double tax) {
            this.tax = tax;
            return this;
        }

        public IncomeStatement commonCharges(final double commonCharges) {
            this.commonCharges = commonCharges;
            return this;
        }

        public IncomeStatement closingCost(final double closingCost) {
            this.closingCost = closingCost;
            return this;
        }

        public double getRent() {
            return rent;
        }

        public double getProceedsFromSale() {
            return proceedsFromSale;
        }

        public double getTotalRevenue() {
            return totalRevenue();
        }


        public double getInterestExpense() {
            return interestExpense;
        }

        public double getTax() {
            return tax;
        }

        public double getCommonCharges() {
            return commonCharges;
        }

        public double getClosingCost() {
            return closingCost;
        }

        public double getTotalExponses() {
            return totalExponses();
        }

        public double getNetIncome() {
            return netIncome();
        }

        public IncomeStatement period(final int period) {
            this.period = period;
            return this;
        }
    }
}

