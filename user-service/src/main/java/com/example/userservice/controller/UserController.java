package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final Environment env;
    private final Greeting greeting;

    private final UserService userService;

    @GetMapping("/welcome")
    public String statue(){
//        return env.getProperty("greeting.message");
        return greeting.getMessage();
    }

    @GetMapping("/heath_check")
    public String status(){
        return "It's Working in User Serice";
    }

    @PostMapping("users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody @Valid RequestUser requestUser){
        //request vo -> response
        UserDto userDto = UserDto.of(requestUser.getEmail(), requestUser.getName(), requestUser.getPwd());

        //logic
        UserDto signUpDto = userService.createUser(userDto);

        return ResponseEntity.status(CREATED).body(ResponseUser.of(signUpDto));
    }
}
