package org.example.practice.common.domain;

public record ApiResponse<T>(String HttpStatus, String message, T data) {
}
