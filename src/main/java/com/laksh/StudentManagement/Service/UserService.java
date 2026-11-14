package com.laksh.StudentManagement.Service;

import com.laksh.StudentManagement.Entity.User;
import com.laksh.StudentManagement.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
