package com.example.to_do_list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
        Menu superior
    */
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
                //Implementar ordenação por prioridade;
                break;
            case R.id.itemOrdenarInsercao:
                //Carregar normal;
                break;
            case R.id.itemFechar:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}