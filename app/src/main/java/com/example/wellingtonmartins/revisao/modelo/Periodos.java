package com.example.wellingtonmartins.revisao.modelo;

import java.io.Serializable;

/**
 * Created by Wellington Martins on 10/06/2016.
 */
public class Periodos implements Serializable {
    private int ID_PERIODO;
    private String DS_PERIODO;

    public int getID_PERIODO() {
        return ID_PERIODO;
    }

    public void setID_PERIODO(int ID_PERIODO) {
        this.ID_PERIODO = ID_PERIODO;
    }

    public String getDS_PERIODO() {
        return DS_PERIODO;
    }

    public void setDS_PERIODO(String DS_PERIODO) {
        this.DS_PERIODO = DS_PERIODO;
    }

    @Override
    public String toString() {
        return getDS_PERIODO();
    }
}
