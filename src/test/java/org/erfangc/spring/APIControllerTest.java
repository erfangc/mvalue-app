package org.erfangc.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.erfangc.MvalueAppApplication;
import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.mtg.MtgAssumptions;
import org.erfangc.spring.models.Assumptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * {@link APIControllerTest}
 *
 * Created by erfangchen on 5/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvalueAppApplication.class})
@WebAppConfiguration
public class APIControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void incomeStatementTimeSeries() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(
                new Assumptions(
                        new MtgAssumptions()
                                .homePrice(500000).ltv(0.8).rate(0.04625).nper(360),
                        new PropertyAssumptions()
                                .rent(3600)
                                .investmentHorizonInYrs(11)
                                .commonCharges(384.00)
                                .propertyTax(319.00)
                                .insurance(0.0)
                                .cumulativeAppreciation(0.2)
                                .buyingClosingCost(30000.00)
                                .sellingClosingCost(42000)
                )
        );
        ResultActions action = mockMvc.perform(post("/api/analysis").content(requestBody).contentType(MediaType.APPLICATION_JSON_UTF8));
        action.andExpect(content().json(FileUtils.readFileToString(new ClassPathResource("spring/analysis.expected.json").getFile(), StandardCharsets.UTF_8)));
    }

}