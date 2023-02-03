package com.example.testegps;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testegps.controller.EntradaController;

public class SettingsActivity extends AppCompatActivity {

    private TextView nameTxt;
    private TextView emailTxt;
    private Spinner assuntoSpinner;
    private TextView descricaoTxt;
    private Button salvarBtn;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameTxt = findViewById(R.id.nomeCadTxt);
        emailTxt = findViewById(R.id.emailCadTxt);
        assuntoSpinner = findViewById(R.id.assuntoCadSpinner);
        descricaoTxt = findViewById(R.id.descricaoCadTxt);
        salvarBtn = findViewById(R.id.salvarBtn);


        carregaSpinners();
        registraEventos();

        }


    private void registraEventos(){
        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastraEntrada();
            }
        });


    }

    private void carregaSpinners(){
        String valores[] = new String[421];
        valores[0] = "indefinido";

        for(int i = 1; i <= 420;i++){
            valores[i] = i + "";
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(SettingsActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,valores);

    }

    private void cadastraEntrada(){
        String nome = nameTxt.getText().toString();
        String email = emailTxt.getText().toString();
        String assunto = (String)assuntoSpinner.getSelectedItem();
        String descricao = descricaoTxt.getText().toString();

        EntradaController controller = new EntradaController(SettingsActivity.this);

        //se ocorreu erro vamos indicar para o user

        if(!controller.insertEntrada(nome, email, assunto, descricao)){
            Toast.makeText(SettingsActivity.this,"problema!!!",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(SettingsActivity.this,"gravou!!!",
                    Toast.LENGTH_SHORT).show();
        }

        setResult(RESULT_OK);

        finish();
    }


}
