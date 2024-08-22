package org.example.practice.test.mockito.user.repository;

import org.example.practice.test.mockito.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findById(String id);
}
