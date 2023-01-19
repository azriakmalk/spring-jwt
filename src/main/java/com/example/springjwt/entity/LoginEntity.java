package com.example.springjwt.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginEntity {
    private String phone;
    private String password;
}
