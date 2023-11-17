package com.example.todoproject.service;

import com.example.todoproject.constant.Role;
import com.example.todoproject.domain.User;
import com.example.todoproject.exception.UserNotFound;
import com.example.todoproject.repository.UserRepository;
import com.example.todoproject.request.CreateUserDto;
import com.example.todoproject.response.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Transactional
    public void save(CreateUserDto createUserDto) {
        log.info("CreateUserDto = {}", createUserDto);
        User user = User.builder()
                .userId(createUserDto.getUserId())
                .password(createUserDto.getPassword())
                .name(createUserDto.getName())
                .role(Role.USER)
                .createAt(LocalDateTime.now())
                .updatedAt(null)
                .build();

        userRepository.save(user);
    }

    public UserResponse get(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return UserResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .name(user.getName())
                .role(user.getRole())
                .build();

    }
}
