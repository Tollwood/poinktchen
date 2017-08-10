package com.app.rest;


import com.app.App;
import com.app.entity.Company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyRestApiTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getCompanies() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(createUrlWithPort("/api/companies"),
                HttpMethod.GET, entity, String.class);
        assertEquals(200,response.getStatusCodeValue() );
    }

    @Test
    public void createCompanies() throws JSONException, IOException {
        headers.setContentType(MediaType.APPLICATION_JSON);
        final Company company = new Company();
        company.setName("Company");
        final String companyAsJson = new ObjectMapper().writeValueAsString(company);
        HttpEntity<String> entity = new HttpEntity<>(companyAsJson,headers);
        ResponseEntity<String> response = restTemplate.exchange(createUrlWithPort("/api/companies"),
                HttpMethod.POST, entity, String.class);
        assertEquals(200,response.getStatusCodeValue() );


        assertNotNull(response.getBody());
        final Company createdCompamy = new ObjectMapper().readValue(response.getBody(), Company.class);
        assertEquals(company.getName(),createdCompamy.getName());
        assertNotNull(createdCompamy.getId());
    }

    private String createUrlWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
