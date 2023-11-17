package com.example.todoproject.request;

import com.example.todoproject.constant.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@ToString
@Getter
@Setter
public class CreateUserDto {

    private String userId;

    private String password;

    private String name;
    @Builder
    public CreateUserDto(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
}
