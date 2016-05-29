**(Under Development, Not Stable!)**

# mvalue-core

Mortgage Investment IRR and CF calculator App

# Why?

Investing in properties shouldn't be purely speculative. I believe real estate assets derive their value from Free Cashflow just like every other investment.

Even though many intangible and unpredictable factors affect the valuation and realized return of real estate investments, it shouldn't prohibit us from running prospective deals through a financial model.

# How?

The model presented in this App is crude (at first) but forms a foundation upon which more complicated valuation assumptions can be added.

The model assumes the investor will finance the purchase of a property with a 30 Year Fixed Mortgage. His/her annual expenses are that of Interest / Carry and taxes. His/her revenue shall be rent.

We assume the investor will exit the investment at the end of his investment horizon, using proceeds from the sale to satisfy the remaining balance on his/her mortgage.

# Where can we go from here?

I believe housing prices must be supported by rent, and rent level is supported by income. Thus, it is not sustainable to see overall housing price appreciate faster than income growth society wide (i.e. > GDP)
  
However, given a certain GDP growth figure, the proportion of those growth will not be evenly distributed geographically, thus contributing to uneven appreciation/depreciation in housing prices.

Given this framework, the next modeling effort should be focused on predicting income growth by geography.
  
Other factors that significantly impact property valuation such as 

# How to run your own instance?

```bash
mvnw install run
```

Then visit `localhost:8080`

# REST API

``
/POST /api/analysis
Content-Type: application/json
Content: @see Assumptions.java
Returns: @see AnalysisResult.java
```

# Technology

**Server / Computation** Java / Spring Boot

**Front End** React.js with Redux

**UX** Material Design

**Deployment Platform** heroku

**Backend** Postgrel SQL
