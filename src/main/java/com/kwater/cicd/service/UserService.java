package com.kwater.cicd.service;

import com.kwater.cicd.domain.user.User;
import com.kwater.cicd.domain.user.UserRepository;
import com.kwater.cicd.dto.user.UserResponseDto;
import com.kwater.cicd.handler.exception.ErrorCode;
import com.kwater.cicd.handler.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    @Transactional(readOnly = true)
    public UserResponseDto findById(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        return new UserResponseDto(user);
    }
}
