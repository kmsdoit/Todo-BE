package com.example.todoproject.service;

import com.example.todoproject.constant.Role;
import com.example.todoproject.domain.User;
import com.example.todoproject.repository.UserRepository;
import com.example.todoproject.request.CreateUserDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저 등록 테스트")
    void save() {
        //given
        CreateUserDto createUserDto = CreateUserDto.builder()
                .userId("test1")
                .password("testpassword")
                .name("test1")
                .role(Role.USER)
                .build();

        //when
        userService.save(createUserDto);

        //then
        assertEquals(1L, userRepository.count());
        User user = userRepository.findAll().get(0);
        assertEquals("test1", user.getUserId());
        assertEquals("test1", user.getName());
    }
}
