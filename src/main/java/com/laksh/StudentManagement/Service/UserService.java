package com.laksh.StudentManagement.Service;

import com.laksh.StudentManagement.Entity.Role;
import com.laksh.StudentManagement.Entity.User;
import com.laksh.StudentManagement.Repository.RoleRepo;
import com.laksh.StudentManagement.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final private UserRepo userRepo;
    final private RoleRepo roleRepo;

    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User createUser(User user) {

        Role defaultRole = roleRepo.findByRole("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.setRoles(List.of(defaultRole));

        return userRepo.save(user);
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
