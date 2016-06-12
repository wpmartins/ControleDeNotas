package com.example.wellingtonmartins.revisao.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wellington Martins on 25/05/2016.
 */
public class Notas implements Serializable {

    public int ID_DISCIPLINA;
    public double AV1B1;
    public double AV1B2;
    public double AV2;
    public double AV3;
    public double AV1B1P;
    public double AV1B2P;
    public double AV2P;
    public double AV3P;
    public double MEDIA;
    public String DS_DISCIPLINA;

    public int getID_DISCIPLINA() {
        return ID_DISCIPLINA;
    }

    public void setID_DISCIPLINA(int ID_DISCIPLINA) {
        this.ID_DISCIPLINA = ID_DISCIPLINA;
    }

    public double getAV1B1() {
        return AV1B1;
    }

    public void setAV1B1(double AV1B1) {
        this.AV1B1 = AV1B1;
    }

    public double getAV1B2() {
        return AV1B2;
    }

    public void setAV1B2(double AV1B2) {
        this.AV1B2 = AV1B2;
    }

    public double getAV2() {
        return AV2;
    }

    public void setAV2(double AV2) {
        this.AV2 = AV2;
    }

    public double getAV3() {
        return AV3;
    }

    public void setAV3(double AV3) {
        this.AV3 = AV3;
    }

    public double getAV1B1P() {
        return AV1B1P;
    }

    public void setAV1B1P(double AV1B1P) {
        this.AV1B1P = AV1B1P;
    }

    public double getAV1B2P() {
        return AV1B2P;
    }

    public void setAV1B2P(double AV1B2P) {
        this.AV1B2P = AV1B2P;
    }

    public double getAV2P() {
        return AV2P;
    }

    public void setAV2P(double AV2P) {
        this.AV2P = AV2P;
    }

    public double getAV3P() {
        return AV3P;
    }

    public void setAV3P(double AV3P) {
        this.AV3P = AV3P;
    }

    public double getMEDIA() {
        return MEDIA;
    }

    public void setMEDIA(double MEDIA) {
        this.MEDIA = MEDIA;
    }

    public String getDS_DISCIPLINA() {
        return DS_DISCIPLINA;
    }

    public void setDS_DISCIPLINA(String DS_DISCIPLINA) {
        this.DS_DISCIPLINA = DS_DISCIPLINA;
    }

    @Override
    public String toString() {
        double av11 = getAV1B1() * 0.25;
        double av12 = getAV1B2() * 0.25;
        double av2 = getAV2() * 0.3;
        double av3 = getAV3() * 0.2;
        return "Disciplina: "+getDS_DISCIPLINA()
                +"\n"
                +"\nAV1/1ºBimestre:  "+getAV1B1()
                +"\nAV1/2ºBimestre:  "+getAV1B2()
                +"\nAV2:                      "+getAV2()
                +"\nAV3:                      "+getAV3()
                +"\nMédia Final:          "+(av11+av12+av2+av3)
                +"\n";

    }
}

