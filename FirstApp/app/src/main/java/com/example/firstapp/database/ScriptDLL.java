package com.example.firstapp.database;

public class ScriptDLL {
    public static String getCreateTableUser(){
        StringBuilder sql = new StringBuilder();

        sql.append(" CREATE TABLE IF NOT EXISTS USERCLIENT (");
        sql.append("    LOGIN VARCHAR (35) NOT NULL DEFAULT (''), ");
        sql.append("    CODE INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sql.append("    SENHA VARCHAR (35) NOT NULL DEFAULT (''), ");
        sql.append("    NOME VARCHAR (55) NOT NULL DEFAULT ('') ) ");
        return  sql.toString();
    }

    public static  String getCreateTableAposta(){
        StringBuilder sql = new StringBuilder();

        sql.append(" CREATE TABLE IF NOT EXISTS APOSTACLIENT (");
        sql.append(" TIME1 VARCHAR(35) NOT NULL DEFAULT (''), ");
        sql.append(" TIME2 VARCHAR(35) NOT NULL DEFAULT (''), ");
        sql.append(" VALORAPOSTADO FLOAT NOT NULL DEFAULT '0', ");
        sql.append(" VALORRETORNO FLOAT NOT NULL DEFAULT '0', ");
        sql.append(" CODIGODOAPOSTADOR INTEGER NOT NULL DEFAULT '0', ");
        sql.append(" CODIGO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        return  sql.toString();
    }
}
