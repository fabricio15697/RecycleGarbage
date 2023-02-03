package com.example.testegps.controller;

import android.content.Context;

import com.example.testegps.modelo.Entrada;
import com.example.testegps.repository.EntradaRepository;

public class EntradaController {

    private Context contexto;

    public EntradaController(Context contexto){
        this.contexto = contexto;
    }



    public boolean insertEntrada(Entrada novaEntrada){
        if(novaEntrada != null){
            EntradaRepository repository = new EntradaRepository(contexto);
            return repository.insertEvento(novaEntrada);
        }

        return false;
    }

    public boolean insertEntrada(String nome, String email, String assunto, String descricao){

        //verificando os parametros passados no cadastro
        if(nome != null && !nome.isEmpty() && !email.isEmpty()&& email!=null && assunto != null && !assunto.isEmpty() && !descricao.isEmpty()&& descricao!=null){

            Entrada novaEntrada = new Entrada(nome, email, assunto, descricao);

            //executa o INSERT
            return insertEntrada(novaEntrada);
        }else{
            return false;
        }
    }

}
