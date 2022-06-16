package com.kwater.cicd.service;

import com.kwater.cicd.domain.flooding.Flooding;
import com.kwater.cicd.domain.flooding.FloodingRepository;
import com.kwater.cicd.dto.flooding.FloodingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FloodingService {
    private final FloodingRepository floodingRepository;

    @Transactional(readOnly = true)
    public FloodingDto getFloodingInfo(){

        List<Flooding> floodings = floodingRepository.findAll();

        FloodingDto floodingDto = new FloodingDto(floodings.get(floodings.size()-1));

        return floodingDto;
    }

}
