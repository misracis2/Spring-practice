package org.example.practice.test.mockito.user.controller;

import org.example.practice.common.domain.ApiResponse;
import org.example.practice.test.mockito.user.controller.dto.UserSignUpRequest;
import org.example.practice.test.mockito.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ApiResponse<?> signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userService.signUp(userSignUpRequest);
    }
}
