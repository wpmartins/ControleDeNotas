package com.example.wellingtonmartins.revisao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wellingtonmartins.revisao.banco.CriarBanco;
import com.example.wellingtonmartins.revisao.modelo.Notas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wellington Martins on 25/05/2016.
 */
public class NotasDAO {

    private static String TB_NOME = "NOTAS";
    private SQLiteDatabase db;
    private CriarBanco banco;

    public NotasDAO(Context baseContext) {
        banco = new CriarBanco(baseContext);
    }

    public String inserir(Notas notas){
        ContentValues valores;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("ID_DISCIPLINA", notas.getID_DISCIPLINA());
        valores.put("AV1B1", notas.getAV1B1());
        valores.put("AV1B2", notas.getAV1B2());
        valores.put("AV2", notas.getAV2());
        valores.put("AV3", notas.getAV3());

        db.insert(TB_NOME, null, valores);
        db.close();

        return "Registro Salvo !";
    }

    public void update(Notas notas){
        ContentValues cv = new ContentValues();
        cv.put("ID_DISCIPLINA", notas.getID_DISCIPLINA());
        cv.put("AV1B1", notas.getAV1B1());
        cv.put("AV1B2", notas.getAV1B2());
        cv.put("AV2", notas.getAV2());
        cv.put("AV3", notas.getAV3());

        db.update(TB_NOME, cv, "ID_DISCIPLINA = ?", new String[]{String.valueOf(notas.getID_DISCIPLINA())});
    };

    public void delete(Notas notas){
        db.delete(TB_NOME, "ID_DISCIPLINA = ?", new String[]{String.valueOf(notas.getID_DISCIPLINA())});
    };

    public List<Notas> list(int id){
        Cursor cursor;

        String[] campos = {"NOTAS.ID_DISCIPLINA","DS_DISCIPLINA","AV1B1","AV1B2","AV2","AV3"};

        db = banco.getReadableDatabase();
        cursor = db.query(TB_NOME+" INNER JOIN DISCIPLINAS ON DISCIPLINAS.ID_DISCIPLINA = NOTAS.ID_DISCIPLINA " +
                "INNER JOIN PERIODOS ON PERIODOS.ID_PERIODO = DISCIPLINAS.ID_PERIODO", campos, "" +
                "DISCIPLINAS.ID_PERIODO = "+id, null,null, null, null);

        List<Notas> listaNotas = new ArrayList<>();
        while (cursor.moveToNext()){
            Notas obj = new Notas();
            obj.setID_DISCIPLINA(cursor.getInt(0));
            obj.setDS_DISCIPLINA(cursor.getString(1));
            obj.setAV1B1(cursor.getDouble(2));
            obj.setAV1B2(cursor.getDouble(3));
            obj.setAV2(cursor.getDouble(4));
            obj.setAV3(cursor.getDouble(5));

            listaNotas.add(obj);
        }
        cursor.close();
        return  listaNotas;


    };
}
