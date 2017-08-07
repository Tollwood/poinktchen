package com.app.controller;

import com.app.entity.Company;
import com.app.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {


    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void addCompany(Company company){
        companyService.save(company);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateCompany(Company company){
        companyService.save(company);
    }

    @RequestMapping("/delete")
    public void deleteCompany(Company company){
        companyService.delete(company);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Company> getAllCompanies(){
        return companyService.findAll();
    }

    @RequestMapping(value = "/searchByName", method = RequestMethod.GET, params = "name")
    public Company findCompanyByName(String name){
        return companyService.findByName(name);
    }


}
