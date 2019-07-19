package com.example.firstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firstapp.database.DadosOpenHelper;
import com.example.firstapp.dominio.entidades.Cliente;
import com.example.firstapp.dominio.repositorio.ClienteRepositorio;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonLimpar;
    private Button buttonResetar;
    private EditText editLogin;
    private EditText editSenha;
    private TextView login;
    private TextView senha;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private ConstraintLayout layout_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_main = (ConstraintLayout)findViewById(R.id.layout_main);
        buttonLimpar = (Button)findViewById(R.id.buttonLimpar);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonResetar = (Button) findViewById(R.id.buttonResetar);
        editLogin = (EditText) findViewById(R.id.SteamLogin);
        editSenha = (EditText) findViewById(R.id.SteamSenha);
        login = (TextView) findViewById(R.id.LabelLogin);
        senha = (TextView) findViewById(R.id.LabelSenha);

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editLogin.setText("");
                editSenha.setText("");
            }
        });

        criarConexao();
    }

    private void criarConexao(){
        try {
            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();
            Snackbar.make(layout_main, getString(R.string.message_conexao_success), Snackbar.LENGTH_SHORT).setAction("OK", null).show();

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(getString(R.string.message_ok), null);
            dlg.show();
        }
    }
    public void confirmar(View view){
        //login.setText(editLogin.getText());
        //senha.setText(editSenha.getText());

        String _login = editLogin.getText().toString();
        String _senha = editSenha.getText().toString();

        if (_login.isEmpty() || _senha.isEmpty()){
            Snackbar.make(view, "Campo vazio", Snackbar.LENGTH_LONG).show();
        }else {

            ClienteRepositorio clienteRepositorio = new ClienteRepositorio(conexao);
            Cliente user  = clienteRepositorio.buscar(_login, _senha);

            if (user != null){

                Intent intent = new Intent(this, TelaActivity.class);
                intent.putExtra("login", editLogin.getText());
                intent.putExtra("nome", user.Nome);
                startActivity(intent);
            }else{
                Snackbar.make(view, "Usuário ou Senha inválidos", Snackbar.LENGTH_LONG).show();
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(editLogin != null && editSenha != null){
            editLogin.setText("");
            editSenha.setText("");
        }

    }

    public void registrar(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
