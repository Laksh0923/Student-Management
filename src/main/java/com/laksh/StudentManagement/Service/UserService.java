package com.laksh.StudentManagement.Service;

import com.laksh.StudentManagement.DTO.request.StudentCreateRequestDto;
import com.laksh.StudentManagement.DTO.response.StudentCreateResponseDto;
import com.laksh.StudentManagement.Entity.Role;
import com.laksh.StudentManagement.Entity.User;
import com.laksh.StudentManagement.Mapper.StudentMapper;
import com.laksh.StudentManagement.Repository.RoleRepo;
import com.laksh.StudentManagement.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final private UserRepo userRepo;
    final private RoleRepo roleRepo;
    final private StudentMapper mapper;

    public UserService(UserRepo userRepo, RoleRepo roleRepo, StudentMapper mapper) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.mapper = mapper;
    }

    public List<StudentCreateResponseDto> getUsers(){
        return userRepo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public StudentCreateResponseDto createUser(StudentCreateRequestDto studentRequestDto) {

        User user = mapper.toEntity(studentRequestDto);

        Role defaultRole = roleRepo.findByRole("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.setRoles(List.of(defaultRole));

        User savedUser = userRepo.save(user);

        return mapper.toDto(savedUser);
    }

    public StudentCreateResponseDto updateUser(StudentCreateRequestDto studentCreateRequestDto) {
        User user = mapper.toEntity(studentCreateRequestDto);
        User savedUser = userRepo.save(user);

        return mapper.toDto(savedUser);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}