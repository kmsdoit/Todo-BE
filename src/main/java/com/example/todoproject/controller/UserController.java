package com.example.todoproject.controller;

import com.example.todoproject.request.CreateUserDto;
import com.example.todoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody CreateUserDto request) {
        userService.save(request);
    }
}
