package org.example.practice.test.mockito.user.repository;

import org.assertj.core.api.Assertions;
import org.example.practice.test.mockito.user.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @InjectMocks
    private UserRepository userRepository;

    @Mock
    private UserJpaRepository userJpaRepository;
    @Test
    void saveUser() {
        //given
        User user = User.builder()
                .id("id")
                .password("password")
                .name("name")
                .build();
        //when
        doReturn(Optional.of(user)).when(userJpaRepository).findById(user.getId());

        //then
        Assertions.assertThatThrownBy(() -> userRepository.saveUser(user))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("user already exists");
    }
}