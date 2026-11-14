package com.laksh.StudentManagement.Controller;

import com.laksh.StudentManagement.Entity.User;
import com.laksh.StudentManagement.Repository.UserRepo;
import com.laksh.StudentManagement.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    final private UserService userService;
    final private UserRepo userRepo;

    StudentController(UserService userService, UserRepo userRepo) {
        this.userService =  userService;
        this.userRepo = userRepo;
    }

    @GetMapping()
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        return userRepo.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    return ResponseEntity.ok(userRepo.save(user));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping()
    public void deleteUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
    }
}
