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

    public Map<Integer, IncomeStatement> toMap() {
        return this.isTbl;
    }

    @Override
    public String toString() {
        return "IncomeStatementTimeSeries{" +
                "isTbl=" + isTbl +
                '}';
    }

    public static class IncomeStatement {
        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        private int period;
        private double rent = 0, proceedsFromSale = 0;
        private double interestExpense = 0, tax = 0, commonCharges = 0, closingCost = 0;

        public double rent() {
            return this.rent;
        }

        public double proceedsFromSale() {
            return this.proceedsFromSale;
        }

        public double totalRevenue() {
            return this.rent + this.proceedsFromSale;
        }

        public double interestExpense() {
            return this.interestExpense;
        }

        public double tax() {
            return this.tax;
        }

        public double commonCharges() {
            return this.commonCharges;
        }

        public double closingCost() {
            return this.closingCost;
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

        public void setRent(double rent) {
            this.rent = rent;
        }

        public double getProceedsFromSale() {
            return proceedsFromSale;
        }

        public void setProceedsFromSale(double proceedsFromSale) {
            this.proceedsFromSale = proceedsFromSale;
        }

        public double getTotalRevenue() {
            return totalRevenue();
        }


        public double getInterestExpense() {
            return interestExpense;
        }

        public void setInterestExpense(double interestExpense) {
            this.interestExpense = interestExpense;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public double getCommonCharges() {
            return commonCharges;
        }

        public void setCommonCharges(double commonCharges) {
            this.commonCharges = commonCharges;
        }

        public double getClosingCost() {
            return closingCost;
        }

        public void setClosingCost(double closingCost) {
            this.closingCost = closingCost;
        }

        public double getTotalExponses() {
            return totalExponses();
        }

        public double getNetIncome() {
            return netIncome();
        }


        public int period() {
            return this.period;
        }

        public IncomeStatement period(final int period) {
            this.period = period;
            return this;
        }

        @Override
        public String toString() {
            return "IncomeStatement{" +
                    "period=" + period +
                    ", rent=" + rent +
                    ", proceedsFromSale=" + proceedsFromSale +
                    ", interestExpense=" + interestExpense +
                    ", tax=" + tax +
                    ", commonCharges=" + commonCharges +
                    ", closingCost=" + closingCost +
                    '}';
        }
    }
}

