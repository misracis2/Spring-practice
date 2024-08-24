package org.example.practice.common.domain;

import lombok.Builder;
import org.springframework.http.HttpStatus;


public record ApiResponse<T>(HttpStatus httpStatus, String message, T data) {

    @Builder
    public ApiResponse {
        httpStatus = HttpStatus.OK;
        message = HttpStatus.OK.getReasonPhrase();
        data = null;
    }
}
