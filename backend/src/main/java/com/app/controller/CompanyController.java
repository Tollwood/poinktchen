package com.app.controller;

import com.app.entity.Company;
import com.app.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {


    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/api/companies", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Company createCompany(@RequestBody Company company){
        return companyService.save(company);
    }

    @RequestMapping(value = "/api/companies/{id}", method = RequestMethod.PUT)
    public Company updateCompany(@PathVariable("id") long id, @RequestBody Company company) {
        return companyService.update(id, company);
    }

    @RequestMapping(value = "/api/companies/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(Company company){
        companyService.delete(company);
    }

    @RequestMapping("/api/companies")
    public List<Company> getAllCompanies(){
        return companyService.findAll();
    }

    @RequestMapping("/api/companies/{id}")
    public Company getCompany(@PathVariable("id") long id) {
        return companyService.findById(id);
    }

    @RequestMapping(value = "/api/companies", method = RequestMethod.GET, params = "name")
    public Company findCompanyByName(String name){
        return companyService.findByName(name);
    }

}