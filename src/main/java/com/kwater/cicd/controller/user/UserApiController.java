package com.kwater.cicd.controller.user;


import com.kwater.cicd.dto.http.BasicResponse;
import com.kwater.cicd.dto.http.SuccessDataResponse;
import com.kwater.cicd.dto.user.UserResponseDto;
import com.kwater.cicd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @GetMapping(path = "/user/info/{userId}")
    public ResponseEntity<? extends BasicResponse> findById(@PathVariable Long userId){
        UserResponseDto userResponseDto = userService.findById(userId);
        return ResponseEntity.ok().body(new SuccessDataResponse<UserResponseDto>(userResponseDto));
    }

}
