package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonLimpar;
    private Button buttonResetar;
    private EditText editLogin;
    private EditText editSenha;
    private TextView login;
    private TextView senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }
    public void confirmar(View view){
        login.setText(editLogin.getText());
        senha.setText(editSenha.getText());

        Intent intent = new Intent(this, TelaActivity.class);
        intent.putExtra("login", login.getText());
        startActivity(intent);
    }

    public void resetar(View view){
        login.setText(getText(R.string.txt_Login));
        senha.setText(getText(R.string.txt_Senha));
    }
}
