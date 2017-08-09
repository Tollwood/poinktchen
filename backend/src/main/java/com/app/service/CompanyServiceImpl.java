package com.app.service;

import com.app.entity.Company;
import com.app.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(long id, Company company) {
        Company currentCompany = findById(id);
        currentCompany.setName(company.getName());
        currentCompany.setDescription(company.getDescription());
        companyRepository.save(company);
        return  currentCompany;
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public Company findById(long id) {
        return companyRepository.findOne(id);
    }
}