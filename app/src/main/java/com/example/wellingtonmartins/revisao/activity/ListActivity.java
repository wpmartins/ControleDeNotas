package com.example.wellingtonmartins.revisao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.wellingtonmartins.revisao.R;
import com.example.wellingtonmartins.revisao.dao.NotasDAO;
import com.example.wellingtonmartins.revisao.dao.PeriodosDAO;
import com.example.wellingtonmartins.revisao.modelo.Notas;
import com.example.wellingtonmartins.revisao.modelo.Periodos;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_list)
public class ListActivity extends AppCompatActivity {

    private NotasDAO notasDAO;
    private Notas notas;
    private PeriodosDAO periodosDAO;
    private  int posicao;

    @ViewById
    ListView lvNotas;

    @ViewById
    Spinner spPeriodo;

    @AfterViews
    public void init(){
        periodosDAO = new PeriodosDAO(this);

        List<Periodos> listarPeriodos = periodosDAO.listar();
        ArrayAdapter<Periodos> arrayPeriodos =
                new ArrayAdapter<Periodos>(this, android.R.layout.simple_spinner_dropdown_item, listarPeriodos);
        spPeriodo.setAdapter(arrayPeriodos);

        spPeriodo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    posicao = position + 1;
                    listarNotas(posicao);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void listarNotas(int id){
        notasDAO = new NotasDAO(this);
        final List<Notas> notasList = notasDAO.list(id);
        final ArrayAdapter<Notas> arrayNotas = new ArrayAdapter<Notas>(this, android.R.layout.simple_list_item_1, notasList);
        lvNotas.setAdapter(arrayNotas);
    }
    @ItemClick(R.id.lvNotas)
    public void estadoClick(Notas notas){
        Intent i = new Intent();
        i.putExtra("NOTAS", notas);

        setResult(CadNotasActivity_.LIST_REQUEST, i);
        finish();
    }

}
