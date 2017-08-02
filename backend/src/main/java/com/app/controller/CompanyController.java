package com.app.controller;

import com.app.entity.Branch;
import com.app.entity.Card;
import com.app.entity.Company;
import com.app.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {


    private ProviderService providerService;

    @Autowired
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

    public void addCompany(){
        providerService.save();
    }

    public void updateCompany(){
        providerService.save();
    }

    public void deleteCompany(Company company){

    }

    public List<Company> getAllCompanies(){
        return new ArrayList<>();
    }

    public List<Company> findCompanyByName(String name){
        return new ArrayList<>();
    }

    public Company addBranch(Long companyId, Branch branch){
        return null;
    }

    public Branch updateBranch(Branch branch){
        return null;
    }

    public void deleteBranch(Long companyId, Long branchId){

    }

    public Card addCard(Long companyId, Card card){
        return null;
    }

    public Card updateCard(Card card){
        return null;
    }

    public void deleteCard(Long companyId, Long CardId){

    }

    public List<Card> getCardsByBranch(Long branchId){
        return new ArrayList<>();
    }
}
