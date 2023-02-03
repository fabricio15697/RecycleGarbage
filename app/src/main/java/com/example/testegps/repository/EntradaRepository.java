package com.example.testegps.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.testegps.banco_dados.EsquemaBanco;
import com.example.testegps.banco_dados.OperacoesBancoDados;
import com.example.testegps.modelo.Entrada;

public class EntradaRepository {

    private Context contexto;

    public EntradaRepository(Context contexto){
        this.contexto = contexto;
    }

    //cadastro
    public boolean insertEvento(Entrada novaEntrada){
        try(OperacoesBancoDados conexaoBanco =
                new OperacoesBancoDados(this.contexto)){

            SQLiteDatabase tran = conexaoBanco.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(EsquemaBanco.Entrada.NOME_COLUNA_NOME, novaEntrada.getNome());
            values.put(EsquemaBanco.Entrada.NOME_COLUNA_EMAIL, novaEntrada.getEmail());
            values.put(EsquemaBanco.Entrada.NOME_COLUNA_ASSUNTO, novaEntrada.getAssunto());

            //executa o INSERT e RETORNA o id gerado pelo autoincrement
            long idGeradoBD = tran.insert(EsquemaBanco.Entrada.NOME_TABELA, null, values);

            if(idGeradoBD > 0){
                novaEntrada.setId(idGeradoBD);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
