package com.example.userservice.vo;

import com.example.userservice.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

    private String email;
    private String name;
    private String userId;
    private List<ResponseOrder> orders;


    public ResponseUser(final String email, final String name, final String userId, final List<ResponseOrder> orders) {
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.orders = orders;
    }

    public static ResponseUser of(final UserDto userDto) {
        return new ResponseUser(userDto.getEmail(), userDto.getName(), userDto.getUserId(), null);
    }


}
