package com.example.todoproject.domain;

import com.example.todoproject.constant.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "users")
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="userId")
    private String userId;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public User(Long id, String userId, String password, String name, Role role, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.role = role;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }
}
