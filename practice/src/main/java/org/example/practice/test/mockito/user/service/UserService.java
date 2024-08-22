package org.example.practice.test.mockito.user.service;

import org.example.practice.common.domain.ApiResponse;
import org.example.practice.test.mockito.user.controller.dto.UserSignUpRequest;
import org.example.practice.test.mockito.user.entity.User;
import org.example.practice.test.mockito.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ValidateUserService validateUserService;
    private final UserRepository userRepository;

    public UserService(ValidateUserService validateUserService, UserRepository userRepository) {
        this.validateUserService = validateUserService;
        this.userRepository = userRepository;
    }

    public ApiResponse<?> signUp(UserSignUpRequest userSignUpRequest) {
        validateUserService.validateUserName(userSignUpRequest.name());

        User user = User.builder()
                .id(userSignUpRequest.id())
                .password(userSignUpRequest.password())
                .name(userSignUpRequest.name())
                .build();

        userRepository.saveUser(user);
        return null;
    }
}
