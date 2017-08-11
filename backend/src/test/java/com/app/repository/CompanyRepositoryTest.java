package com.app.repository;


import com.app.entity.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
                "classpath:data/hsql/init-companies.sql",
        }),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data/hsql/clear.sql")
})
public class CompanyRepositoryTest extends BaseRepositoryTest{

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void findByNameTest() {
        Company company = new Company();
        company.setName("company1");
        company.setId(123L);
        Company fetchedComany = companyRepository.findByName(company.getName());
        assertNotNull(fetchedComany);
        assertEquals(company.getId(), fetchedComany.getId());
    }

    @Test
    public void saveCompanyTest(){
        Company company = new Company();
        company.setName("company3");
        company.setDescription("save me!");
        company.setId(1245L);

        companyRepository.save(company);
        Company fetchedCompany = companyRepository.findByName("company3");
        assertEquals(company.getName(), fetchedCompany.getName());
    }
}
