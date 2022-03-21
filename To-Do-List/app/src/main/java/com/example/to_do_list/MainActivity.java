package com.example.to_do_list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.to_do_list.util.ItemAdapter;
import com.example.to_do_list.util.Notes;
import com.example.to_do_list.util.Persistence;
import com.example.to_do_list.util.Singleton;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private ItemAdapter adapter;

    private void loadNotes(){
        adapter = new ItemAdapter(this,R.layout.layout_note, Singleton.getNotes().getItens());
        listview=((ListView)findViewById(R.id.listview_notes));
        listview.setAdapter(adapter);

        //Click curto
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),AnotacaoDetalhadaActivity.class);
                intent.putExtra("nome",adapter.getItem(i).getNome());
                intent.putExtra("descricao",adapter.getItem(i).getDescricao());
                intent.putExtra("prioridade",adapter.getItem(i).getPrioridade());
                startActivity(intent);
            }
        });

        // Click longo
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(Singleton.getNotes().remove(i))
                {
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,"Anotação excluída.",Toast.LENGTH_LONG);
                }
                return true;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persistence.readData("notes.dad",this);
        loadNotes();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        loadNotes();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Notes notes=Singleton.getNotes();
        if(!Persistence.writeData("notes.dad",notes,this))
            Toast.makeText(this,"Erro ao salvar arquivo de atividades",Toast.LENGTH_LONG).show();
    }

    //Menu superior
    @Override
    // Carrega menu superior
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // Click do menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemNovaAnotacao:
                Intent intent = new Intent(this,NovaAnotacaoActivity.class);
                startActivity(intent);
                break;
            case R.id.itemOrdenarPioridade:
                Singleton.getNotes().getItens().sort((prio2,prio1)->Integer.compare(prio1.getPrioridade(), prio2.getPrioridade()));
                adapter.notifyDataSetChanged();
                break;
            case R.id.itemOrdenarInsercao:
                Singleton.getNotes().getItens().sort(Comparator.comparing(ord->ord.getOrd()));
                adapter.notifyDataSetChanged();
                break;
            case R.id.itemOrdenarAlfabeto:
                Singleton.getNotes().getItens().sort(Comparator.comparing(nome->nome.getNome().toLowerCase()));
                adapter.notifyDataSetChanged();
                break;

            case R.id.itemFechar:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}