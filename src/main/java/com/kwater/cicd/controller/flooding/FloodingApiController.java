package com.kwater.cicd.controller.flooding;

import com.kwater.cicd.dto.flooding.FloodingDto;
import com.kwater.cicd.dto.http.BasicResponse;
import com.kwater.cicd.dto.http.SuccessDataResponse;
import com.kwater.cicd.service.FloodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FloodingApiController {

    private final FloodingService floodingService;

    @GetMapping("/flooding")
    public ResponseEntity<? extends BasicResponse> getFloodingInfo(){
        FloodingDto floodingDto = floodingService.getFloodingInfo();
        return ResponseEntity.ok().body(new SuccessDataResponse<FloodingDto>(floodingDto));
    }
}
