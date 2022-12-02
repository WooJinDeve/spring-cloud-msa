package com.example.userservice.vo;

import com.example.userservice.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUser {

    private String email;
    private String name;
    private String userId;


    public ResponseUser(String email, String name, String userId) {
        this.email = email;
        this.name = name;
        this.userId = userId;
    }

    public static ResponseUser of(UserDto userDto) {
        return new ResponseUser(userDto.getEmail(), userDto.getName(), userDto.getUserId());
    }


}
