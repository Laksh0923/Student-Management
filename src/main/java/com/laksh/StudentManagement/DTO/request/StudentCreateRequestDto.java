package com.laksh.StudentManagement.DTO.request;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequestDto {

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

}
