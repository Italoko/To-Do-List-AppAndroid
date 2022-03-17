package com.example.to_do_list;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.to_do_list.util.Item;
import com.example.to_do_list.util.Singleton;

public class NovaAnotacaoActivity extends AppCompatActivity {

    private EditText editTextNome, editTextDescricao;
    private RadioButton min,med,max;

    private int getPrioridade(){

        if(min.isChecked())
            return 1;
        else if(med.isChecked())
            return 2;
        else if(max.isChecked())
            return 3;

        return 1;
    }

    private void clearScreen(){
        editTextNome.setText("");
        editTextDescricao.setText("");
        min.setChecked(true);
    }

    private boolean validateFields(@NonNull String nome,  @NonNull String desc){
        if (nome.isEmpty())
        {
            Toast.makeText(this,"Digite nome da nota.",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (desc.isEmpty())
        {
            Toast.makeText(this,"Digite a descrição da nota.",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_anotacao);

        editTextNome = findViewById(R.id.editTextNome);
        editTextDescricao = findViewById(R.id.editTextDescricao);

        min = findViewById(R.id.radioPrioMin);
        med = findViewById(R.id.radioPrioMed);
        max = findViewById(R.id.radioPrioMax);

        findViewById(R.id.btnGravarAnotacao).setOnClickListener(e->{
            String noteName = editTextNome.getText().toString();
            String noteDesc = editTextDescricao.getText().toString();

            if(validateFields(noteName,noteDesc)){
                Item note = new Item(noteName,noteDesc,getPrioridade());
                Singleton.getNotes().add(note);

                Toast.makeText(this,"Nota registrada com sucesso.",Toast.LENGTH_LONG).show();
                clearScreen();
            }
        });
    }
}