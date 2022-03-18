package com.example.to_do_list;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AnotacaoDetalhadaActivity extends AppCompatActivity {
    private Button btnVoltar;
    private TextView textViewNome, textViewDesc, textViewPrio;

    private void loadNote(){
        textViewNome.setText(getIntent().getStringExtra("nome"));
        textViewDesc.setText((getIntent().getStringExtra("descricao")));

        String prioridade="Não identificado";
        switch (getIntent().getIntExtra("prioridade",1)){
            case 1:
                prioridade = "Minima";
                textViewPrio.setTextColor(Color.WHITE);
                textViewPrio.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                prioridade = "Média";
                textViewPrio.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                prioridade = "Máxima";
                textViewPrio.setBackgroundColor(Color.RED);
                break;
        }
        textViewPrio.setText(prioridade);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacao_detalhada);

        textViewNome = findViewById(R.id.textViewNomeDetalhado);
        textViewDesc = findViewById(R.id.textViewDescricaoDetalhado);
        textViewPrio = findViewById(R.id.textViewPrioDetalhado);

        loadNote();

        btnVoltar = findViewById(R.id.btnVoltarDetalhado);
        btnVoltar.setOnClickListener(e->{
            finish();
        });
    }
}