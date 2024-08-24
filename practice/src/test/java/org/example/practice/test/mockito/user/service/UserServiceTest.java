package org.example.practice.test.mockito.user.service;

import org.assertj.core.api.Assertions;
import org.example.practice.common.domain.ApiResponse;
import org.example.practice.test.mockito.user.controller.dto.UserSignUpRequest;
import org.example.practice.test.mockito.user.entity.User;
import org.example.practice.test.mockito.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private ValidateUserService validateUserService;
    @Mock
    private UserRepository userRepository;

    @DisplayName("회원가입 성공 케이스")
    @Test
    void signUp() {
        //given
        UserSignUpRequest userSignUpRequest = new UserSignUpRequest("id", "password", "name");

        //when
        doNothing().when(validateUserService).validateUserName(userSignUpRequest.name());
        doNothing().when(userRepository).saveUser(any(User.class));

        //then
        ApiResponse<?> response = userService.signUp(userSignUpRequest);
        Assertions.assertThat(response.httpStatus()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.message()).isEqualTo("OK");
    }
}