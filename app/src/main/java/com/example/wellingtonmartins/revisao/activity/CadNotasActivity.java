package com.example.wellingtonmartins.revisao.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wellingtonmartins.revisao.R;
import com.example.wellingtonmartins.revisao.dao.DisciplinasDAO;
import com.example.wellingtonmartins.revisao.dao.PeriodosDAO;
import com.example.wellingtonmartins.revisao.modelo.Disciplinas;
import com.example.wellingtonmartins.revisao.modelo.Periodos;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@OptionsMenu(R.menu.menu_main)
@EActivity(R.layout.activity_cad_notas)
public class CadNotasActivity extends AppCompatActivity {
    private DisciplinasDAO disciplinasDAO;
    private PeriodosDAO periodosDAO;

    @ViewById
    Spinner spDisciplinas;

    @ViewById
    EditText edtPeriodo;

    @ViewById
    EditText edtAv1b1;

    @ViewById
    EditText edtAv1b2;

    @ViewById
    EditText edtAv2;

    @ViewById
    EditText edtAv3;

    @ViewById
    EditText edtAv1b1P;

    @ViewById
    EditText edtAv1b2P;

    @ViewById
    EditText edtAv2P;

    @ViewById
    EditText edtAv3P;

    @AfterViews
    public void init(){
        disciplinasDAO = new DisciplinasDAO(this);
        periodosDAO = new PeriodosDAO(this);

        List<Disciplinas> listarDisciplinas = disciplinasDAO.listar();

        ArrayAdapter<Disciplinas> arrayDisciplinas =
                new ArrayAdapter<Disciplinas>(this, android.R.layout.simple_spinner_dropdown_item, listarDisciplinas);
        spDisciplinas.setAdapter(arrayDisciplinas);

        spDisciplinas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int p = position+1;
                String periodo = periodosDAO.retornaDescricao(p);
                edtPeriodo.setText(periodo);
                Toast.makeText(getApplicationContext(), "id selecionado :" + p, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    //public void init(){
    //    notasDao = new DisciplinasDAO(this);
    //}
    //
    //public Notas getEstado(){
    //    Notas notas = new Notas();
    //    notas.setNome(edtNome.getText().toString());
    //    try {
    //        notas.setCod(Integer.parseInt(edtId.getText().toString()));
    //    } catch (NumberFormatException e){
    //
    //    }
    //    return notas;
    //}
    //
    //public void setEstado(Notas notas){
    //    edtId.setText(String.valueOf(notas.getCod()));
    //    edtNome.setText(notas.getNome());
    //
    //}
    //public void limpar(){
    //    edtId.setText("");
    //    edtNome.setText("");
    //}
    //
    //
    //@OptionsItem(R.id.mnSalvar)
    //public void salvar(){
    //    Notas e = new Notas();
    //    if (e.getCod() == 0){
    //        notasDao.add(e);
    //    } else {
    //        notasDao.update(e);
    //    }
    //
    //    limpar();
    //
    //}
    //@OptionsItem(R.id.mnListar)
    //public void listar(){
    //    startActivityForResult(new Intent(this, ListActivity_.class), LIST_REQUEST);
    //}
    //
    //@OptionsItem(R.id.mnDel)
    //public void delete(){
    //    Notas e = new Notas();
    //    notasDao.delete(e);
    //    limpar();
    //}
    //
    //@OnActivityResult(LIST_REQUEST)
    //public void listResult ( int resultCode, Intent data, @OnActivityResult.Extra String value){
    //    Notas e = (Notas) data.getExtras().getSerializable("estado");
    //    setEstado(e);
    //}
    //
}
