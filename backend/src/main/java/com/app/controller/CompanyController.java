package com.app.controller;

import com.app.entity.Company;
import com.app.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController extends BaseController{


    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/api/companies", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Company create(@RequestBody Company company){
        return companyService.save(company);
    }

    @RequestMapping(value = "/api/companies/{id}", method = RequestMethod.PUT)
    public Company update(@PathVariable("id") long id, @RequestBody Company company) {
        return companyService.update(id, company);
    }

    @RequestMapping(value = "/api/companies/{id}", method = RequestMethod.DELETE)
    public void delete(Company company){
        companyService.delete(company);
    }

    @RequestMapping(value= "/api/companies",  method = RequestMethod.GET)
    public List<Company> getAll(){
        return companyService.findAll();
    }
 	

	@RequestMapping("/api/companies/{id}")
    public Company getCompany(@PathVariable("id") long id) {
        return companyService.findById(id);
    }

    @RequestMapping(value = "/searchByName", method = RequestMethod.GET, params = "name")
    public Company findByName(String name){
        return companyService.findByName(name);
    }

}