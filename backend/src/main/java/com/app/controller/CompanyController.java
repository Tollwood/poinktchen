package com.app.controller;

import com.app.entity.Company;
import com.app.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {


    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/api/company", method = RequestMethod.POST)
    public void createCompany(@RequestBody Company company){
        companyService.save(company);
    }

    @RequestMapping(value = "/api/company/{id}", method = RequestMethod.PUT)
    public Company updateCompany(@PathVariable("id") long id, @RequestBody Company company) {
        return companyService.update(id, company);
    }

    @RequestMapping("/delete")
    public void deleteCompany(Company company){
        companyService.delete(company);
    }

    @RequestMapping("/api/company")
    public List<Company> getAllCompanies(){
        return companyService.findAll();
    }

    @RequestMapping(value = "/searchByName", method = RequestMethod.GET, params = "name")
    public Company findCompanyByName(String name){
        return companyService.findByName(name);
    }

}