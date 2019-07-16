package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TelaActivity extends AppCompatActivity {

    private TextView labelnome;
    private String _labelsenha;
    private FloatingActionButton buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela);

        labelnome = (TextView) findViewById(R.id.Label_Visualizar1);
        buttonReturn = findViewById(R.id.floatingActionButton);
       // _labelnome = labelnome.getText().toString();
        //_labelsenha =
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
               //Intent intent = new Intent(this, MainActivity.class);
               // startActivity(intent);


            }
        });



        labelnome.setText(getIntent().getExtras().get("login").toString());

    }
}
