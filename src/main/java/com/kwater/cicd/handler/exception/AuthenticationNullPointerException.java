package com.kwater.cicd.handler.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthenticationNullPointerException extends RuntimeException{
    private final ErrorCode errorCode;
}
