package com.example.firstapp.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.firstapp.dominio.entidades.Cliente;

public class ClienteRepositorio {

    private SQLiteDatabase conexao;

    public ClienteRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void inserir(Cliente cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("LOGIN", cliente.Nome);
        contentValues.put("Senha", cliente.Senha);
        contentValues.put("Nome", cliente.Nome);

        conexao.insertOrThrow("USERCLIENT", null, contentValues);
    }

    public  void excluir(int code){
        String[] parametro = new String[1];
        parametro[0] = String.valueOf(code);

        conexao.delete("USERCLIENT","CODIGO = ?", parametro);
    }

    public void alterar(Cliente cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("LOGIN", cliente.Nome);
        contentValues.put("Senha", cliente.Senha);
        contentValues.put("Nome", cliente.Nome);

        String[] parametro = new String[1];
        parametro[0] = String.valueOf(cliente.Code);

        conexao.update("USERCLIENT", contentValues, "CODIGO = ?", parametro);

    }

    public Cliente buscar(string login, string senha){
        Cliente cliente = new Cliente();

        String selectQuery = "SELECT * FROM USERCLIENT " + "WHERE LOGIN = '" + login + "'" + "AND SENHA = '" + senha + "'";

        Cursor resultado = conexao.rawQuery(selectQuery, null);

        if (resultado.getCount() > 0){
            resultado.moveToFirst();

            cliente.Nome = resultado.getString( resultado.getColumnIndexOrThrow("NOME"));
            cliente.Code = resultado.getInt( resultado.getColumnIndexOrThrow("CODE"));
            return cliente;
        }else
            return null;
    }
}
