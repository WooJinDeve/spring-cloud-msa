package com.example.userservice.service;

import com.example.userservice.domain.UserEntity;
import com.example.userservice.domain.UserRepository;
import com.example.userservice.dto.UserDto;
import com.example.userservice.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserDto userDto = UserDto.of(userEntity);

        //TODO: 주문정보 DATA 추가
        List<ResponseOrder> orders = new ArrayList<>();
        userDto.addOrders(orders);

        return userDto;
    }

    @Override
    public List<UserDto> getUserByAll() {
        return userRepository.findAll().stream()
                .map(UserDto::of)
                .collect(Collectors.toList());
    }
}
