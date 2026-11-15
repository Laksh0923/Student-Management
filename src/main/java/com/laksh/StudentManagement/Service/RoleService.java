package com.laksh.StudentManagement.Service;

import com.laksh.StudentManagement.Entity.Role;
import com.laksh.StudentManagement.Repository.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    final private RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    public void addRole(Role role){
        roleRepo.save(role);
    }
}
