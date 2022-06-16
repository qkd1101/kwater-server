package com.kwater.cicd.domain.flooding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "barr")
public class Flooding {

    @Id
    private int id;

    private int gj;

    private int bj;

    private int sjo;

    private int gg;

    private int gm;

    private int nd;

    private int ds;

    private int sju;

    private int ch;

    private int cg;

    @Override
    public String toString() {
        return "Flooding{" +
                "id=" + id +
                ", gj=" + gj +
                ", bj=" + bj +
                ", sjo=" + sjo +
                ", gg=" + gg +
                ", gm=" + gm +
                ", nd=" + nd +
                ", ds=" + ds +
                ", sju=" + sju +
                ", ch=" + ch +
                ", cg=" + cg +
                '}';
    }
}
