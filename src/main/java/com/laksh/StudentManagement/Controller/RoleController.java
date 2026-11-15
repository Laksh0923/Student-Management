package com.laksh.StudentManagement.Controller;

import com.laksh.StudentManagement.Entity.Role;
import com.laksh.StudentManagement.Service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    final private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public String addRole(@RequestBody Role role){
        roleService.addRole(role);
        return "Role added successfully";
    }
}
