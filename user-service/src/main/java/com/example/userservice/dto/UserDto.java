package com.example.userservice.dto;

import com.example.userservice.domain.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private LocalDateTime createdAt;
    private String encryptedPwd;

    public UserDto(String email, String name, String userId, String pwd, LocalDateTime createdAt, String encryptedPwd) {
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.pwd = pwd;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.encryptedPwd = encryptedPwd;
    }

    public static UserDto of(String email, String name, String password){
        return new UserDto(email, name, null,password, null, null);
    }

    public static UserDto of(UserEntity entity){
        return new UserDto(entity.getEmail(), entity.getName(), entity.getUserId(),
                null, entity.getCreatedAt(), entity.getEncryptedPwd());
    }
}
