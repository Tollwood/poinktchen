package com.app.service;

import com.app.entity.Branch;
import com.app.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BranchServiceImpl implements BranchService {

    private BranchRepository branchRepository;

    @Override
    public Branch create(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch update(Branch branch) {
        Branch currentBranch = branchRepository.findOne(branch.getId());
        if(currentBranch != null){
            currentBranch.setDescription(branch.getDescription());
            currentBranch.setName(branch.getName());
            branchRepository.save(currentBranch);
        }
        return currentBranch;
    }

    @Override
    public void delete(Branch branch) {
        branchRepository.delete(branch);
    }

    @Override
    public List<Branch> getAllForCompany(Long CompanyId) {
        return null;
    }

    @Autowired
    public void setBranchRepository(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }
}
