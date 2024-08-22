package org.example.practice.test.mockito.user.repository;

import org.example.practice.test.mockito.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public void saveUser(User user) {
        userJpaRepository.findById(user.getId())
                .ifPresent(u -> {throw new RuntimeException("user already exists");});
        userJpaRepository.save(user);
    }
}
