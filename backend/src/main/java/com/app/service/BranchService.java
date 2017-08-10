package com.app.service;

import com.app.entity.Branch;

import java.util.List;

public interface BranchService {

    Branch create(Branch branch);
    Branch update (Branch branch);
    void delete(Branch branch);
    List<Branch> getAllForCompany(Long CompanyId);
}
