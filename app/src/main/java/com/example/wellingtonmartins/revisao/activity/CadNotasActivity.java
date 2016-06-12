package com.example.wellingtonmartins.revisao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wellingtonmartins.revisao.R;
import com.example.wellingtonmartins.revisao.dao.DisciplinasDAO;
import com.example.wellingtonmartins.revisao.dao.NotasDAO;
import com.example.wellingtonmartins.revisao.dao.PeriodosDAO;
import com.example.wellingtonmartins.revisao.modelo.Disciplinas;
import com.example.wellingtonmartins.revisao.modelo.Notas;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@OptionsMenu(R.menu.menu_main)
@EActivity(R.layout.activity_cad_notas)
public class CadNotasActivity extends AppCompatActivity {
    public static final int LIST_REQUEST = 600;
    private DisciplinasDAO disciplinasDAO;
    private PeriodosDAO periodosDAO;
    private NotasDAO notasDao;
    private Notas notas;
    private  int posicao;

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

    @ViewById
    EditText edtMediaFinal;

    @AfterViews
    public void init(){
        edtAv1b1.setEnabled(false);
        edtAv1b2.setEnabled(false);
        edtAv2.setEnabled(false);
        edtAv3.setEnabled(false);

        disciplinasDAO = new DisciplinasDAO(this);
        periodosDAO = new PeriodosDAO(this);
        notasDao = new NotasDAO(this);

        setAdapterNotas();
    }

    private void setAdapterNotas() {
        List<Disciplinas> listarDisciplinas = disciplinasDAO.listar();

        ArrayAdapter<Disciplinas> arrayDisciplinas =
                new ArrayAdapter<Disciplinas>(this, android.R.layout.simple_spinner_dropdown_item, listarDisciplinas);
        spDisciplinas.setAdapter(arrayDisciplinas);
        spDisciplinas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    posicao = position + 1;
                    String periodo = periodosDAO.retornaDescricao(posicao);
                    edtPeriodo.setText(periodo);
                    String tipoMateria = disciplinasDAO.retornaTipo(posicao);
                    campos(tipoMateria);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void campos(String tipoMateria) {
        if(tipoMateria.toString().equals("S")){
            edtAv3.setEnabled(true);
            edtAv1b1.setEnabled(false);
            edtAv1b2.setEnabled(false);
            edtAv2.setEnabled(false);

        } else if(tipoMateria.toString().equals("N")) {
            edtAv1b1.setEnabled(true);
            edtAv1b2.setEnabled(true);
            edtAv2.setEnabled(true);
            edtAv3.setEnabled(true);
        }
    }

    public Notas getCampos(Notas notas){
        double vazio = 0;

        notas.setID_DISCIPLINA(posicao);
        if(edtAv1b1.getText().toString().equals("")){
            notas.setAV1B1(vazio);
        } else {
            notas.setAV1B1(Double.parseDouble(edtAv1b1.getText().toString()));
        }

        if(edtAv1b2.getText().toString().equals("")){
            notas.setAV1B2(vazio);
        } else {
            notas.setAV1B2(Double.parseDouble(edtAv1b2.getText().toString()));
        }

        if(edtAv2.getText().toString().equals("")){
            notas.setAV2(vazio);
        } else {
            notas.setAV2(Double.parseDouble(edtAv2.getText().toString()));
        }

        if(edtAv3.getText().toString().equals("")){
            notas.setAV3(vazio);
        } else {
            notas.setAV3(Double.parseDouble(edtAv3.getText().toString()));
        }
        return notas;
    }

    private Notas calcular(Notas obj) {
        double media;
        obj.setAV1B1P(obj.getAV1B1() * 0.25);
        media = (obj.getAV1B1() * 0.25);
        obj.setAV1B2P(obj.getAV1B2() * 0.25);
        media = media + (obj.getAV1B2() * 0.25);
        obj.setAV2P(obj.getAV2() * 0.3);
        media = media + (obj.getAV2() * 0.3);
        obj.setAV3P(obj.getAV3() * 0.2);
        media = media +(obj.getAV3() * 0.2);
        obj.setMEDIA(media);
        return obj;
    }

    private void setCampos(Notas obj) {
        spDisciplinas.setSelection(obj.getID_DISCIPLINA() - 1);

        edtAv1b1.setText(String.valueOf(obj.getAV1B1()));
        edtAv1b2.setText(String.valueOf(obj.getAV1B2()));
        edtAv2.setText(String.valueOf(obj.getAV2()));
        edtAv3.setText(String.valueOf(obj.getAV3()));

        NumberFormat campoFomatado = new DecimalFormat("#.#");
        edtAv1b1P.setText(String.valueOf(campoFomatado.format(obj.getAV1B1P())));
        edtAv1b2P.setText(String.valueOf(campoFomatado.format(obj.getAV1B2P())));
        edtAv2P.setText(String.valueOf(campoFomatado.format(obj.getAV2P())));
        edtAv3P.setText(String.valueOf(campoFomatado.format(obj.getAV3P())));
        edtMediaFinal.setText(String.valueOf(campoFomatado.format(obj.getMEDIA())));
    }

    private void limparCampos() {
        edtAv1b1.setText("");
        edtAv1b2.setText("");
        edtAv2.setText("");
        edtAv3.setText("");
        edtMediaFinal.setText("");
        edtAv1b1P.setText("");
        edtAv1b2P.setText("");
        edtAv2P.setText("");
        edtAv3P.setText("");
    }

    private void limparSpinner(){
        spDisciplinas.setSelection(0);
        edtPeriodo.setText("");
    }


    @Click(R.id.btnGravar)
    public void btnGravar(){
        Notas obj = new Notas();
        String retorno = notasDao.inserir(getCampos(obj));
        Toast.makeText(this, retorno, Toast.LENGTH_LONG).show();
        limparCampos();
        limparSpinner();

    }

    @Click(R.id.btnCalcular)
    public void btnCalcular(){
        double media;
        Notas obj = new Notas();
        setCampos(calcular(getCampos(obj)));

    }
    @Click(R.id.btnLimpar)
    public void btnLimpar(){
        limparCampos();
    }

    @OptionsItem(R.id.mnListar)
    public void listar(){
        startActivityForResult(new Intent(this, ListActivity_.class), LIST_REQUEST);
    }

    @OnActivityResult(LIST_REQUEST)
    public void listResult (int resultCode, Intent data, @OnActivityResult.Extra String value) {
        try {
            Notas obj = (Notas) data.getExtras().getSerializable("notas");
            setCampos(obj);

        } catch (NullPointerException ex) {
            Log.e("MSG", "Não voltou estado.");
        }
    }
}
