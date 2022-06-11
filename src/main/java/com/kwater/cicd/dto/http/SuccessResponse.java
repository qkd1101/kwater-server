package com.kwater.cicd.dto.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SuccessResponse {
    private int status;

    public SuccessResponse() {
        this.status = HttpStatus.OK.value();
    }
}
