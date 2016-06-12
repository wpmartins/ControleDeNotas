package com.example.wellingtonmartins.revisao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wellingtonmartins.revisao.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_list)
public class ListActivity extends AppCompatActivity {


   // @ViewById
   // ListView lvEstado;
   //
   // DisciplinasDAO notasDAO;
   //
   // @AfterViews
   // public void init(){
   //     notasDAO = new DisciplinasDAO(this);
   //
   //     ArrayAdapter<Notas> aaEstado = new ArrayAdapter<Notas>(this, android.R.layout.simple_list_item_1, notasDAO.list());
   //
   //     lvEstado.setAdapter(aaEstado);
   // }
   //
   // @ItemClick(R.id.lvEstado)
   // public void estadoClick(Notas notas){
   //     Intent i = new Intent();
   //     i.putExtra("notas", notas);
   //
   //     setResult(CadNotasActivity_.LIST_REQUEST, i);
   //     finish();
   // }

}
