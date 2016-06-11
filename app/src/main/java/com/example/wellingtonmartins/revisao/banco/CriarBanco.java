package com.example.wellingtonmartins.revisao.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wellington Martins on 10/06/2016.
 */
public class CriarBanco extends SQLiteOpenHelper {

    public static final int VERSAO = 1;
    public CriarBanco(Context context) {super(context, "banco.db", null, VERSAO);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_PERIODOS = " CREATE TABLE PERIODOS ("+
                "ID_PERIODO INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DS_PERIODO TEXT)";
        db.execSQL(SQL_PERIODOS);

        String SQL_DISCIPLINAS = "CREATE TABLE DISCIPLINAS ("+
                "ID_DISCIPLINA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DS_DISCIPLINA TEXT, " +
                "ID_PERIODO INTEGER, " +
                "IN_TIPO CHAR(1), " +
                "FOREIGN KEY(ID_PERIODO) REFERENCES PERIODOS(ID_PERIODO))";
        db.execSQL(SQL_DISCIPLINAS);

        String SQL_NOTAS = "CREATE TABLE NOTAS ("+
                "ID_DISCIPLINA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "AV1B1 NUMERIC, " +
                "AV1B2 NUMERIC, " +
                "AV2 NUMERIC, " +
                "AV3 NUMERIC, " +
                "FOREIGN KEY(ID_DISCIPLINA) REFERENCES DISCIPLINAS(ID_DISCIPLINA))";
        db.execSQL(SQL_NOTAS);

        String insert;

        insert = "INSERT INTO PERIODOS (DS_PERIODO) VALUES ('1º Período')";
        db.execSQL(insert);

        insert = "INSERT INTO PERIODOS (DS_PERIODO) VALUES ('2º Período')";
        db.execSQL(insert);

        insert = "INSERT INTO PERIODOS (DS_PERIODO) VALUES ('3º Período')";
        db.execSQL(insert);

        insert = "INSERT INTO PERIODOS (DS_PERIODO) VALUES ('4º Período')";
        db.execSQL(insert);

        insert = "INSERT INTO PERIODOS (DS_PERIODO) VALUES ('5º Período')";
        db.execSQL(insert);

        insert = "INSERT INTO PERIODOS (DS_PERIODO) VALUES ('6º Período')";
        db.execSQL(insert);

        String insert1 = "INSERT INTO DISCIPLINAS (DS_DISCIPLINA,ID_PERIODO,IN_TIPO) " +
                "VALUES ('Algoritmos',1,'N')";
        db.execSQL(insert1);

        String insert2 = "INSERT INTO DISCIPLINAS (DS_DISCIPLINA,ID_PERIODO,IN_TIPO) " +
                "VALUES ('Formação Geral',1,'N')";
        db.execSQL(insert2);

        String insert3 = "INSERT INTO DISCIPLINAS (DS_DISCIPLINA,ID_PERIODO,IN_TIPO) " +
                "VALUES ('Projeto Integrador',1,'S')";
        db.execSQL(insert3);

        String insert4 = "INSERT INTO DISCIPLINAS (DS_DISCIPLINA,ID_PERIODO,IN_TIPO) " +
                "VALUES ('Modelagem de Dados',2,'N')";
        db.execSQL(insert4);

        String insert5 = "INSERT INTO DISCIPLINAS (DS_DISCIPLINA,ID_PERIODO,IN_TIPO) " +
                "VALUES ('Programação Estruturada',2,'N')";
        db.execSQL(insert5);

        String insert6 = "INSERT INTO DISCIPLINAS (DS_DISCIPLINA,ID_PERIODO,IN_TIPO) " +
                "VALUES ('Projeto Integrador II',2,'S')";
        db.execSQL(insert6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
