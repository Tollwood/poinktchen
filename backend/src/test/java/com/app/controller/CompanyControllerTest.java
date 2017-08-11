package com.app.controller;

import com.app.entity.Company;
import com.app.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static com.app.util.JsonMapper.toJson;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class CompanyControllerTest extends BaseControllerTest{

    @Mock
    private CompanyService companyService;

    @InjectMocks
    @Autowired
    private CompanyController companyController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        setUp(companyController);
    }

    @Test
    public void createCompanyTest() throws Exception {
        Company company = new Company();
        company.setDescription("Test");
        company.setName("name");

        when(companyService.save(any(Company.class))).thenReturn(company);

        MvcResult result = mvc.perform(post("/api/companies")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(toJson(company)))
                .andReturn();

        int status = result.getResponse().getStatus();

        verify(companyService, times(1)).save(any(Company.class));
        assertEquals("Expected HTTP status 200", 200, status);


    }
}
