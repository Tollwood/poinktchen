package com.app.service;

import com.app.entity.Company;
import com.app.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.save(company);
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
}
