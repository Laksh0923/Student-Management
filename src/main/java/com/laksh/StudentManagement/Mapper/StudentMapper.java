package com.laksh.StudentManagement.Mapper;

import com.laksh.StudentManagement.DTO.request.StudentCreateRequestDto;
import com.laksh.StudentManagement.DTO.response.StudentCreateResponseDto;
import com.laksh.StudentManagement.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public User toEntity(StudentCreateRequestDto studentCreateRequestDto){

        User user = new User();

        user.setUsername(studentCreateRequestDto.getUsername());
        user.setPassword(studentCreateRequestDto.getPassword());

        return user;
    }

    public StudentCreateResponseDto toDto(User user){

        StudentCreateResponseDto studentCreateResponseDto = new StudentCreateResponseDto();
        studentCreateResponseDto.setId(user.getId());
        studentCreateResponseDto.setUsername(user.getUsername());
        studentCreateResponseDto.setCreateTime(user.getCreationTime());
        studentCreateResponseDto.setUpdatedTime(user.getUpdatedTime());
        studentCreateResponseDto.setMessage("Successfully added.");

        return studentCreateResponseDto;
    }
}
