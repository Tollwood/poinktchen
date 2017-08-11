package com.app.rest;


import com.app.App;
import com.app.entity.Company;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
                "classpath:data/hsql/init-companies.sql"
        }),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data/hsql/clear.sql")
})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(
        locations = "classpath:application-test.properties")
@ActiveProfiles(value = "test")
public class CompanyRestApiTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void createCompany() throws JSONException, IOException {
        //given
        headers.setContentType(MediaType.APPLICATION_JSON);
        final Company company = new Company();
        company.setName("Company");
        final String companyAsJson = new ObjectMapper().writeValueAsString(company);
        HttpEntity<String> entity = new HttpEntity<>(companyAsJson,headers);

        //when
        ResponseEntity<String> response = restTemplate.exchange(createUrlWithPort("/api/companies"),
                HttpMethod.POST, entity, String.class);

        //then
        assertEquals(200,response.getStatusCodeValue() );
        assertNotNull(response.getBody());
        final Company createdCompamy = new ObjectMapper().readValue(response.getBody(), Company.class);
        assertEquals(company.getName(),createdCompamy.getName());
        assertNotNull(createdCompamy.getId());
    }

    @Test
    public void getCompany() throws JSONException, IOException {
        //given
        long id = 123;
        //when
        final Company company = getCompanyById(id);
        //then
        assertNotNull(company);
        assertEquals(Long.valueOf(id), company.getId());
    }

    @Test
    public void updateCompany() throws JSONException, IOException {
        //given
        final long id = 123;
        final String someOtherDescription = "someOtherDescription";
        final Company company = getCompanyById(id);
        headers.setContentType(MediaType.APPLICATION_JSON);
        //when
        company.setDescription(someOtherDescription);
        final String companyAsJson = new ObjectMapper().writeValueAsString(company);
        HttpEntity<String> entity = new HttpEntity<>(companyAsJson,headers);
        ResponseEntity<String> getPutResponse = restTemplate.exchange(createUrlWithPort("/api/companies/"+id),
                HttpMethod.PUT, entity, String.class);

        //then
        assertEquals(200,getPutResponse.getStatusCodeValue() );
        assertNotNull(getPutResponse.getBody());
        final Company createdCompamy = new ObjectMapper().readValue(getPutResponse.getBody(), Company.class);
        assertEquals(someOtherDescription,createdCompamy.getDescription());
        assertNotNull(createdCompamy.getId());
    }

    @Test
    public void deleteCompany() throws JSONException, IOException {
        //given
        final long id = 123;

        //when
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createUrlWithPort("/api/companies/"+id),
                HttpMethod.DELETE, entity, String.class);

        //then
        assertEquals(200, response.getStatusCodeValue() );
        assertNull(getCompanyByIdResponse(id).getBody());
    }

    @Test
    public void getCompanies() throws JSONException, IOException {
        //given
        HttpEntity<String> entity = new HttpEntity<>(null,headers);

        //when
        ResponseEntity<String> response = restTemplate.exchange(createUrlWithPort("/api/companies"),
                HttpMethod.GET, entity, String.class);
        //then
        assertEquals(200,response.getStatusCodeValue() );
        List<Company> companies = new ObjectMapper().readValue(response.getBody(), new TypeReference<List<Company>>(){});
        assertEquals(2, companies.size());
    }

    private Company getCompanyById(long id) throws IOException {
        ResponseEntity<String> response = getCompanyByIdResponse(id);
        return  new ObjectMapper().readValue(response.getBody(), Company.class);
    }

    private ResponseEntity<String> getCompanyByIdResponse(long id) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        return restTemplate.exchange(createUrlWithPort("/api/companies/"+ id),
                HttpMethod.GET, entity, String.class);
    }

    private String createUrlWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
