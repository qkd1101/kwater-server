package com.kwater.cicd.dto.flooding;

import com.kwater.cicd.domain.flooding.Flooding;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FloodingDto {

    private int gongju;
    private int baekje;
    private int sejong;
    private int gangjeonggoreyong;
    private int gumi;
    private int nakdan;
    private int dalseong;
    private int sangju;
    private int changneyonghaman;
    private int chilgok;

    public FloodingDto(Flooding entity){
        this.gongju = entity.getGj();
        this.baekje = entity.getBj();
        this.sejong = entity.getSjo();
        this.gangjeonggoreyong = entity.getGg();
        this.gumi = entity.getGm();
        this.nakdan = entity.getNd();
        this.dalseong = entity.getDs();
        this.sangju = entity.getSju();
        this.changneyonghaman = entity.getCh();
        this.chilgok = entity.getCg();
    }
}
