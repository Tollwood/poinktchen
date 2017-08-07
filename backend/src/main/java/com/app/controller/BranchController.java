package com.app.controller;

import com.app.entity.Branch;
import com.app.entity.Card;
import com.app.entity.Company;
import com.app.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @RequestMapping("/new")
    public Branch addBranch(Branch branch){
        return branchService.save(branch);
    }

    @RequestMapping("/update")
    public Branch updateBranch(Branch branch){
        return branchService.save(branch);
    }

    @RequestMapping("/delete")
    public void deleteBranch(Branch branch){
        branchService.delete(branch);
    }

    public List<Card> getCardsByBranch(Long branchId){
        return new ArrayList<>();
    }
}
