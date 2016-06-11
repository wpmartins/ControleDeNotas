package com.example.wellingtonmartins.revisao.modelo;

import java.io.Serializable;

/**
 * Created by Wellington Martins on 10/06/2016.
 */
public class Disciplinas implements Serializable {

    private int ID_DISCIPLINA;
    private String DS_DISCIPLINA;
    private int ID_PERIODO;
    private String IN_TIPO;

    public int getID_DISCIPLINA() {
        return ID_DISCIPLINA;
    }

    public void setID_DISCIPLINA(int ID_DISCIPLINA) {
        this.ID_DISCIPLINA = ID_DISCIPLINA;
    }

    public String getDS_DISCIPLINA() {
        return DS_DISCIPLINA;
    }

    public void setDS_DISCIPLINA(String DS_DISCIPLINA) {
        this.DS_DISCIPLINA = DS_DISCIPLINA;
    }

    public String getIN_TIPO() {
        return IN_TIPO;
    }

    public void setIN_TIPO(String IN_TIPO) {
        this.IN_TIPO = IN_TIPO;
    }

    public int getID_PERIODO() {
        return ID_PERIODO;
    }

    public void setID_PERIODO(int ID_PERIODO) {
        this.ID_PERIODO = ID_PERIODO;
    }

    @Override
    public String toString() {return getDS_DISCIPLINA();    }
}
