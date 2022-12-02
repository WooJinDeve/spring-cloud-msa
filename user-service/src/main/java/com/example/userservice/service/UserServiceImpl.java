package com.example.userservice.service;

import com.example.userservice.domain.UserEntity;
import com.example.userservice.domain.UserRepository;
import com.example.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
        String encryptedPwd = passwordEncoder.encode(userDto.getPwd());

        UserEntity userEntity = UserEntity.of(userDto.getEmail(), userDto.getName(), userId, encryptedPwd, userDto.getCreatedAt());
        userRepository.save(userEntity);

        return UserDto.of(userEntity);
    }
}
