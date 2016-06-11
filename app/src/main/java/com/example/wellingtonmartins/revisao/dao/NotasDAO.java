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

    public String add(Notas notas){
        ContentValues cv;
        db = banco.getWritableDatabase();
        cv = new ContentValues();

        cv.put("AV1B1", notas.getAV1B1());
        cv.put("AV1B2", notas.getAV1B2());
        cv.put("AV2", notas.getAV2());
        cv.put("AV3", notas.getAV3());

        db.insert(TB_NOME, null, cv);
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

    public List<Notas> list(){
        List<Notas> notas = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM NOTAS", null);

        while (c.moveToNext()){
            Notas n = new Notas();
            n.setID_DISCIPLINA(c.getInt(c.getColumnIndex("ID_DISCIPLINA")));
            n.setAV1B1(c.getDouble(c.getColumnIndex("AV1B1")));
            n.setAV1B2(c.getDouble(c.getColumnIndex("AV1B2")));
            n.setAV2(c.getDouble(c.getColumnIndex("AV2")));
            n.setAV3(c.getDouble(c.getColumnIndex("AV3")));

            notas.add(n);
        }
        c.close();
        return  notas;
    };
}
