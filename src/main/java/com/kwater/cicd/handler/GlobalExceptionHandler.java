package com.kwater.cicd.handler;

import com.kwater.cicd.handler.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    // UnAuthorized
    @ExceptionHandler(value = UnAuthorizedTokenException.class)
    protected ResponseEntity<ErrorResponse> handleUnAuthorizedTokenException() {
        log.error("handleUnAuthorizedTokenException throw Exception : {}", ErrorCode.UNAUTHORIZED_TOKEN);
        return ErrorResponse.toResponseEntity(ErrorCode.UNAUTHORIZED_TOKEN);
    }

    @ExceptionHandler(value = UnAuthorizedRefreshTokenException.class)
    protected ResponseEntity<ErrorResponse> handleUnAuthorizedRefreshTokenException() {
        log.error("handleUnAuthorizedRefreshTokenException throw Exception : {}", ErrorCode.UNAUTHORIZED_REFRESHTOKEN);
        return ErrorResponse.toResponseEntity(ErrorCode.UNAUTHORIZED_REFRESHTOKEN);
    }

    // NULL POINTER
    @ExceptionHandler(value = NullPointerException.class)
    protected ResponseEntity<ErrorResponse> handleNullPointerException() {
        log.error("handleNullPointerException throw Exception : {}", ErrorCode.NULL_POINTER);
        return ErrorResponse.toResponseEntity(ErrorCode.NULL_POINTER);
    }

    @ExceptionHandler(value = AuthenticationNullPointerException.class)
    protected ResponseEntity<ErrorResponse> handleAuthenticationNullPointerException() {
        log.error("handleNullPointerException throw Exception : {}", ErrorCode.NULL_AUTHENTICATION);
        return ErrorResponse.toResponseEntity(ErrorCode.NULL_AUTHENTICATION);
    }


    // NOT FOUND
    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleUserNotFoundException(){
        log.error("handleUserNotFoundException throw Exception : {}", ErrorCode.USER_NOT_FOUND);
        return ErrorResponse.toResponseEntity(ErrorCode.USER_NOT_FOUND);
    }

    @ExceptionHandler(value = RefreshTokenNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleRefreshTokenNotFoundException(){
        log.error("handleRefreshTokenNotFoundException throw Exception : {}", ErrorCode.REFRESH_TOKKEN_NOT_FOUND);
        return ErrorResponse.toResponseEntity(ErrorCode.REFRESH_TOKKEN_NOT_FOUND);
    }

    //TOKEN TYPE MISMATCH
    @ExceptionHandler(value = TokenTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleTokenTypeMismatchException(){
        log.error("handleTokenTypeMismatchException throw Exception : {}", ErrorCode.TOKEN_TYPE_MISMATCH);
        return ErrorResponse.toResponseEntity(ErrorCode.TOKEN_TYPE_MISMATCH);
    }


}
