package org.example.practice.test.mockito.user.service;

import org.example.practice.test.mockito.user.repository.WlfRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateUserService {

    private final WlfRepository wlfRepository;

    public ValidateUserService(WlfRepository wlfRepository) {
        this.wlfRepository = wlfRepository;
    }

    public void validateUserName(String name) {
        if(wlfRepository.findByName(name).isPresent()) throw new RuntimeException("user name is in WLF");
    }
}
