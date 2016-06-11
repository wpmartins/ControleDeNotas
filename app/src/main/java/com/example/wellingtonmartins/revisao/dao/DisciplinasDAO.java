package com.example.wellingtonmartins.revisao.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wellingtonmartins.revisao.banco.CriarBanco;
import com.example.wellingtonmartins.revisao.modelo.Disciplinas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wellington Martins on 10/06/2016.
 */
public class DisciplinasDAO {
    private static String TB_NOME = "DISCIPLINAS";
    private SQLiteDatabase db;
    private CriarBanco banco;

    public DisciplinasDAO(Context baseContext) { banco = new CriarBanco(baseContext); }

    public List<Disciplinas> listar(){
        Cursor cursor;

        String[] campos = {"ID_DISCIPLINA","DS_DISCIPLINA","ID_PERIODO","IN_TIPO"};

        db = banco.getReadableDatabase();
        cursor = db.query(TB_NOME, campos, null, null, null, null, null);

        List<Disciplinas> listaDisciplinas = new ArrayList<>();
        while (cursor.moveToNext()) {
            Disciplinas obj = new Disciplinas();
            obj.setID_DISCIPLINA(cursor.getInt(0));
            obj.setDS_DISCIPLINA(cursor.getString(1));
            obj.setID_PERIODO(cursor.getInt(2));
            obj.setIN_TIPO(cursor.getString(3));

            listaDisciplinas.add(obj);
        }
        cursor.close();

        return listaDisciplinas;
    }
}
