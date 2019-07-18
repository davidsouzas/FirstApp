package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapp.database.DadosOpenHelper;
import com.example.firstapp.dominio.entidades.Cliente;
import com.example.firstapp.dominio.repositorio.ClienteRepositorio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    private FloatingActionButton buttonReturn;
    private Button butttonregistrar;
    private EditText editLogin;
    private EditText editSenha;
    private EditText editNome;
    private DadosOpenHelper dadosOpenHelper;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonReturn = findViewById(R.id.floatingActionButton2);
        editLogin = findViewById(R.id.SteamLogin_register);
        editSenha = findViewById(R.id.SteamSenha_register);
        editNome = findViewById(R.id.SteamNome);
        butttonregistrar = findViewById(R.id.buttonregistrar_register);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                //Intent intent = new Intent(this, MainActivity.class);
                // startActivity(intent);
            }
        });
    }

    public void registrar(View view){
        Cliente cliente = new Cliente();
        dadosOpenHelper = new DadosOpenHelper(this);
        conexao = dadosOpenHelper.getWritableDatabase();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio(conexao);
        cliente.Nome = editNome.getText().toString();
        cliente.Login = editLogin.getText().toString();
        cliente.Senha = editSenha.getText().toString();
        clienteRepositorio.inserir(cliente);

        Snackbar.make(view, "Usuário Cadastrado Com Sucesso", Snackbar.LENGTH_LONG).show();
        editLogin.setText("");
        editSenha.setText("");
        editNome.setText("");
    }
}
