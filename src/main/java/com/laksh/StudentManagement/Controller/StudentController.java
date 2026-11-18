package com.laksh.StudentManagement.Controller;

import com.laksh.StudentManagement.DTO.request.StudentCreateRequestDto;
import com.laksh.StudentManagement.DTO.response.StudentCreateResponseDto;
import com.laksh.StudentManagement.Entity.User;
import com.laksh.StudentManagement.Mapper.StudentMapper;
import com.laksh.StudentManagement.Repository.UserRepo;
import com.laksh.StudentManagement.Service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    final private UserService userService;
    final private UserRepo userRepo;
    final private StudentMapper mapper;

    StudentController(UserService userService, UserRepo userRepo, StudentMapper mapper) {
        this.userService =  userService;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @GetMapping()
    public List<StudentCreateResponseDto> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    public StudentCreateResponseDto createUser(@RequestBody StudentCreateRequestDto studentRequestDto){
        return userService.createUser(studentRequestDto);
    }

    @PutMapping("/{id}")
    public StudentCreateResponseDto updateUser(@PathVariable Long id, @RequestBody StudentCreateRequestDto updatedUser){
        User existingStudent = userRepo.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        existingStudent.setUsername(updatedUser.getUsername());
        existingStudent.setPassword(updatedUser.getPassword());
        User savedUser = userRepo.save(existingStudent);
        return mapper.toDto(savedUser);
    }

    @DeleteMapping()
    public void deleteUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
    }
}
