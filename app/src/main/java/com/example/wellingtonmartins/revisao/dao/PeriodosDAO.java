package com.example.wellingtonmartins.revisao.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wellingtonmartins.revisao.banco.CriarBanco;
import com.example.wellingtonmartins.revisao.modelo.Periodos;

/**
 * Created by Wellington Martins on 10/06/2016.
 */
public class PeriodosDAO {
    private static String TB_NOME = "PERIODOS";
    private SQLiteDatabase db;
    private CriarBanco banco;

    public PeriodosDAO(Context baseContext) { banco = new CriarBanco(baseContext);}

    public String retornaDescricao(int id){
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DS_PERIODO FROM "+TB_NOME+" P " +
                "INNER JOIN DISCIPLINAS D " +
                "ON D.ID_PERIODO = P.ID_PERIODO " +
                "WHERE ID_DISCIPLINA ="+id, null);

        String retorno ="";
        while (cursor.moveToNext()){
        retorno = cursor.getString(0);
        }
        db.close();
        return retorno;
    }
}
