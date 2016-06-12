package com.example.wellingtonmartins.revisao.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
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
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@OptionsMenu(R.menu.list_opcoes)
@EActivity(R.layout.activity_list)
public class ListActivity extends AppCompatActivity {
    public static final int LIST_REQUEST = 600;
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

        setAdapterNotas();

    }

    private void setAdapterNotas() {
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
    public void notasClick (Notas notas) {

        this.notas = notas;

        lvNotas.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                getMenuInflater().inflate(R.menu.list_menu, contextMenu);
                contextMenu.setHeaderTitle("Notas");
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mnAlterar:

                Intent i = new Intent();
                i.putExtra("notas", notas);

                setResult(CadNotasActivity_.LIST_REQUEST, i);
                finish();

                break;

            case R.id.mnDeletar:

                mostraDialogDelete();

                break;

        }

        return super.onContextItemSelected(item);
    }

    private void mostraDialogDelete() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Deletar " + notas.getDS_DISCIPLINA() + " ?");
        builder.setMessage("Deseja realmente deletar ?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {

                notasDAO.delete(notas);
                setAdapterNotas();
                limparLista();
                dialog.dismiss();
            }

        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }

    private void limparLista() {
        lvNotas.setAdapter(null);
    }

    @OptionsItem(R.id.mnNotas)
    public void lancarNotas(){
        startActivityForResult(new Intent(this, CadNotasActivity_.class), LIST_REQUEST);
    }


}
