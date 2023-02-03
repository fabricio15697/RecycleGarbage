package com.example.testegps.banco_dados;

public class EsquemaBanco {

    public static final String NOME_BANCO_DADOS = "assuntos_gps";

    //esta versao deve ser modificada SEMPRE que o esquema do banco é alterado
    //ativa onUpgrade()
    public static final int VERSAO = 1;

    public static final String SQL_CREATE_TABLES = Entrada.SQL_CREATE;

    public static final String SQL_DROP_TABLES = Entrada.SQL_DROP;

    public static class Entrada{
        public static final String NOME_TABELA = "assuntos";

        //id, nome, email, assunto

        public static final String NOME_COLUNA_ID = "id";
        public static final String NOME_COLUNA_NOME = "nome";
        public static final String NOME_COLUNA_EMAIL = "email";
        public static final String NOME_COLUNA_ASSUNTO = "assunto";
        public static final String NOME_COLUNA_DESCRICAO = "descricao";

        /*
        * long id, String nome, String email, String assunto
        * String descricao
        * */

        public static final String COLUNAS[] = {NOME_COLUNA_ID, NOME_COLUNA_NOME, NOME_COLUNA_EMAIL, NOME_COLUNA_ASSUNTO, NOME_COLUNA_DESCRICAO};

        public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS " +
                "assuntos(" +
                NOME_COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NOME_COLUNA_NOME + " TEXT," +
                NOME_COLUNA_EMAIL + " TEXT,"+
                NOME_COLUNA_ASSUNTO + " TEXT,"+
                NOME_COLUNA_DESCRICAO + " TEXT"+
                ");";

        public static final String SQL_DROP = "DROP IF EXISTS calories;";
    }

}
