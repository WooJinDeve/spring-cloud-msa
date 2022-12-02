package com.example.userservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class UserEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String userId;

    @Column(nullable = false, length = 100)
    private String encryptedPwd;

    private LocalDateTime createdAt;

    public UserEntity(Long id, String email, String name, String userId, String encryptedPwd, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.encryptedPwd = encryptedPwd;
        this.createdAt = createdAt;
    }

    public static UserEntity of(final String email,final String  name,final String userId, final String encryptedPwd, final LocalDateTime createAt){
        return new UserEntity(null, email, name, userId, encryptedPwd, createAt);
    }
}
