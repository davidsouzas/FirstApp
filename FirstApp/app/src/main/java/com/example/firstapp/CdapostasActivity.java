package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapp.database.DadosOpenHelper;
import com.example.firstapp.dominio.entidades.Aposta;
import com.example.firstapp.dominio.repositorio.ApostaRepositorio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;

public class CdapostasActivity extends AppCompatActivity {
    private FloatingActionButton buttonReturn;
    private EditText editTime1;
    private EditText editTime2;
    private EditText editValorApostado;
    private EditText editValorRetorno;
    private Integer code;
    private Button buttonconfirmar;
    private DadosOpenHelper dadosOpenHelper;
    private SQLiteDatabase conexao;

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
        dadosOpenHelper = new DadosOpenHelper(this);
        conexao = dadosOpenHelper.getWritableDatabase();
        ApostaRepositorio apostaRepositorio = new ApostaRepositorio(conexao);
        code = Integer.parseInt(getIntent().getExtras().get("code").toString());
        aposta.Time1 = editTime1.getText().toString();
        aposta.Time2 = editTime2.getText().toString();
        aposta.ValorApostado = Float.parseFloat(editValorApostado.getText().toString());
        aposta.ValorRetorno = Float.parseFloat(editValorRetorno.getText().toString());
        aposta.CodigoDoApostador = code;
        apostaRepositorio.inserir(aposta);

        Snackbar.make(view, "Aposta Cadastrada Com Sucesso", Snackbar.LENGTH_LONG).show();
        editTime1.setText("");
        editTime2.setText("");
        editValorApostado.setText("");
        editValorRetorno.setText("");
    }
}
