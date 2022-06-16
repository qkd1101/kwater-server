package com.kwater.cicd.dto.flooding;

import com.kwater.cicd.domain.flooding.Flooding;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FloodingDto {

    private int 공주보;
    private int 백제보;
    private int 세종보;
    private int 강정고령보;
    private int 구미보;
    private int 낙단보;
    private int 달성보;
    private int 상주보;
    private int 창녕함안보;
    private int 칠곡보;

    public FloodingDto(Flooding entity){
        this.공주보 = entity.getGj();
        this.백제보 = entity.getBj();
        this.세종보 = entity.getSjo();
        this.강정고령보 = entity.getGg();
        this.구미보 = entity.getGm();
        this.낙단보 = entity.getNd();
        this.달성보 = entity.getDs();
        this.상주보 = entity.getSju();
        this.창녕함안보 = entity.getCh();
        this.칠곡보 = entity.getCg();
    }
}
