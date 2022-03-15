package com.example.to_do_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import com.example.to_do_list.util.Item;
import com.example.to_do_list.util.Singleton;

public class NovaAnotacaoActivity extends AppCompatActivity {

    private int getPrioridade(){
        RadioButton min = findViewById(R.id.radioPrioMin);
        RadioButton med = findViewById(R.id.radioPrioMed);
        RadioButton max = findViewById(R.id.radioPrioMax);

        if(min.isChecked())
            return 1;
        else if(med.isChecked())
            return 2;
        else if(max.isChecked())
            return 3;

        return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_anotacao);

        findViewById(R.id.btnGravarAnotacao).setOnClickListener(e->{
            String noteName = findViewById(R.id.editTextNome).toString();
            String noteDesc = findViewById(R.id.editTextDescricao).toString();

            Item note = new Item(noteName,noteDesc,getPrioridade());
            Singleton.getNotes().add(note);
        });
    }
}