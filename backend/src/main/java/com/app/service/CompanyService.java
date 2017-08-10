package com.app.service;

import com.app.entity.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);
    Company update(long id, Company company);
    void delete(Company company);
    List<Company> findAll();
    Company findByName(String name);
    Company findById(long id);
}