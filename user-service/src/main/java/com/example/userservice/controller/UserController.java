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
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user-service")
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

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service On PORT %s",
                env.getProperty("local.server.port"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody @Valid RequestUser requestUser){
        //request vo -> response
        UserDto userDto = UserDto.of(requestUser.getEmail(), requestUser.getName(), requestUser.getPwd());

        //logic
        UserDto signUpDto = userService.createUser(userDto);

        return ResponseEntity.status(CREATED).body(ResponseUser.of(signUpDto));
    }


    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        //logic
        List<UserDto> users = userService.getUserByAll();

        //response
        List<ResponseUser> response = users.stream()
                .map(ResponseUser::of)
                .collect(Collectors.toList());

        return ResponseEntity.status(OK).body(response);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> get(@PathVariable String userId){
        //logic
        UserDto userDto = userService.getUserByUserId(userId);

        //response
        ResponseUser response = ResponseUser.of(userDto);

        return ResponseEntity.status(OK).body(response);
    }
}
