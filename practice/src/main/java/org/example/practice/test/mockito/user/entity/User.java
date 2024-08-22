package org.example.practice.test.mockito.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long seq;

    @Column(length = 30, nullable = false, unique = true)
    private String id;
    @Column(length = 30, nullable = false)
    private String password;
    @Column(length = 50, nullable = false)
    private String name;
}
