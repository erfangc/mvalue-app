# mvalue-core

Mortgage Investment IRR and CF calculator Web App to Assist with Home Buying / Investment
See a Demo [Here](https://radiant-journey-76639.herokuapp.com/) *(maybe slow or unresponsive, using free-tier hardware)*

**Warning:** This project is under heavy development and not stable!

[![codecov](https://codecov.io/gh/erfangc/mvalue-app/branch/master/graph/badge.svg)](https://codecov.io/gh/erfangc/mvalue-app)
[![Build Status](https://travis-ci.org/erfangc/mvalue-app.svg?branch=master)](https://travis-ci.org/erfangc/mvalue-app)

# Why?

Investing in properties shouldn't be purely speculative. I believe real estate assets derive their value from Free Cashflow just like every other investment.

Even though many intangible and unpredictable factors affect the valuation and realized return of real estate investments, it shouldn't prohibit us from using pro-forma models as a starting point for gauging prospective deals.

# How?

The model presented in this App is crude (at first) but forms a foundation upon which more complicated valuation assumptions can be added.

The model assumes the investor will finance the purchase of a property with a 30 Year Fixed Mortgage. His/her annual expenses are that of Interest / Carry and taxes. His/her revenue shall be rent.

We assume the investor will exit the investment at the end of his investment horizon, using proceeds from the sale to satisfy the remaining balance on his/her mortgage.

# Where can we go from here?

I believe housing prices must be supported by rent, and rent level is supported by income. Thus, it is not sustainable to see overall housing price appreciate faster than income growth in a given society (i.e. **> GDP**)  
However, given a certain GDP growth figure, the proportion of those growth will not be evenly distributed geographically, thus contributing to uneven appreciation/depreciation in housing prices.
Given this framework, the next modeling effort should be focused on predicting income growth by geography.

Geographic income trends can be inferred from from Tax Return filings. However, several factors contribute noise to this data. For example, certain occupations/demographic consistently under report income due to the cash only nature of their income.

Other factors that significantly impact property valuation such as proximity to amenities, transportation and business districts will be taken into account once I can procure the right data sources. 

# How to run your own instance?

```bash
# if you have maven installed
mvn package && java -jar target/mvalue-app-${VERSION}.jar

# if you do not have maven installed
./mvnw package && java -jar target/mvalue-app-${VERSION}.jar

# then visit localhost:8080
```

# Technology Stack

| Stack              |      Tech                                                                                  |
|--------------------|--------------------------------------------------------------------------------------------|
| Server/Computation | [Java / Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) |
| Front-End          | [React](https://facebook.github.io/react/) with [Redux](http://redux.js.org/index.html)    |
| UX                 | [Material Design](https://www.google.com/design/spec/material-design/introduction.html)    |
| Deployment         | Heroku                                                                                     |
| Backend            | Postgrel                                                                                   |
