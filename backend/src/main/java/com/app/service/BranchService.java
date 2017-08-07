package com.app.service;

import com.app.entity.Branch;

public interface BranchService {

    Branch save(Branch branch);
    Branch update (Branch branch);
    void delete(Branch branch);
}
