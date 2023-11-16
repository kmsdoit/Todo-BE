package com.example.todoproject.service;

import com.example.todoproject.constant.Role;
import com.example.todoproject.domain.User;
import com.example.todoproject.repository.UserRepository;
import com.example.todoproject.request.CreateUserDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void save(CreateUserDto createUserDto) {

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
}
