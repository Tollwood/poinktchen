package com.app.service;

import com.app.entity.Branch;
import com.app.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch update(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public void delete(Branch branch) {
        branchRepository.delete(branch);
    }
}
