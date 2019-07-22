package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapp.dominio.entidades.Aposta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CdapostasActivity extends AppCompatActivity {
    private FloatingActionButton buttonReturn;
    private EditText editTime1;
    private EditText editTime2;
    private EditText editValorApostado;
    private EditText editValorRetorno;
    private Button buttonconfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdapostas);

        editTime1 = findViewById(R.id.editTeam1);
        editTime2 = findViewById(R.id.editTeam2);
        editValorApostado = findViewById(R.id.editQntap);
        editValorRetorno = findViewById(R.id.editValorret);

        buttonReturn = findViewById(R.id.floatingActionButton_back);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void confirmarAposta(View view){
        Aposta aposta = new Aposta();

    }
}
