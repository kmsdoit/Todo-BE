package com.example.todoproject.response;


import com.example.todoproject.constant.Role;
import com.example.todoproject.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

    private final Long id;
    private final String userId;
    private final String name;
    private final Role role;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.userId = user.getUserId();
        this.role = user.getRole();
    }

    @Builder
    public UserResponse(Long id, String userId, String name, Role role) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.role = role;
    }


}
