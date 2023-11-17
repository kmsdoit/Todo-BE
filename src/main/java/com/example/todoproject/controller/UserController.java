package com.example.todoproject.controller;

import com.example.todoproject.request.CreateUserDto;
import com.example.todoproject.response.UserResponse;
import com.example.todoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users/save")
    public void save(@RequestBody CreateUserDto request) {
        log.info("request : {}", request);
        userService.save(request);
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable(value = "id") Long id) {
        return userService.get(id);
    }
}
