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
}

