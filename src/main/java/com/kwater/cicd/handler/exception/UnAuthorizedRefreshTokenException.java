package com.kwater.cicd.handler.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UnAuthorizedRefreshTokenException extends RuntimeException{
    private final ErrorCode errorCode;
}