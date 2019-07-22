package com.example.firstapp.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.firstapp.dominio.entidades.Aposta;
import com.example.firstapp.dominio.entidades.Cliente;

public class ApostaRepositorio {

    private SQLiteDatabase conexao;

    public ApostaRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void inserir(Aposta aposta){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Time1", aposta.Time1);
        contentValues.put("Time2", aposta.Time2);
        contentValues.put("ValorApostado", aposta.ValorApostado);
        contentValues.put("ValorRetorno", aposta.ValorRetorno);
        contentValues.put("CodigoDoApostador", aposta.CodigoDoApostador);

        conexao.insertOrThrow("APOSTACLIENT", null, contentValues);
    }

    public  void excluir(int codigo){
        String[] parametro = new String[1];
        parametro[0] = String.valueOf(codigo);

        conexao.delete("APOSTACLIENT","CODIGO = ?", parametro);
    }

    public void alterar(Aposta aposta){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TIME1", aposta.Time1);
        contentValues.put("TIME2", aposta.Time2);
        contentValues.put("VALORAPOSTADO", aposta.ValorApostado);
        contentValues.put("VALORRETORNO", aposta.ValorRetorno);

        String[] parametro = new String[1];
        parametro[0] = String.valueOf(aposta.codigo);

        conexao.update("APOSTACLIENT", contentValues, "CODIGO = ?", parametro);

    }

    public Aposta buscar(String time1, String time2){
        Aposta aposta = new Aposta();

        String selectQuery = "SELECT * FROM APOSTACLIENT " + "WHERE TIME1 = '" + time1 + "'" + "AND TIME2 = '" + time2 + "'";

        Cursor resultado = conexao.rawQuery(selectQuery, null);

        if (resultado.getCount() > 0){
            resultado.moveToFirst();

            aposta.Time1 = resultado.getString( resultado.getColumnIndexOrThrow("TIME1"));
            aposta.Time2 = resultado.getString( resultado.getColumnIndexOrThrow("TIME2"));
            return aposta;
        }else{
            return null;
        }
    }
}
