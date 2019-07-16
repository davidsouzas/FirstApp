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
}
