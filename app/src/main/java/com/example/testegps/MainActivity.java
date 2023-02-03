package com.example.testegps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.testegps.ferramentas.ControlaGPS;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {

    private TextView posicaoTexto;
    private MapView mapa;
    private IMapController controllerMapa;
    private ImageButton scanBtn;
    private ImageButton settingsBtn;
    private ControlaGPS gpsController;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posicaoTexto = findViewById(R.id.posicaoTxt);
        scanBtn = findViewById(R.id.scanBtn);
        settingsBtn = findViewById(R.id.settingsBtn);
        mapa = findViewById(R.id.mapa);

        requisitaPermissoes();
        registraEventos();

        //acessamos a instancia do controla GPS
        gpsController = ControlaGPS.getInstance(MainActivity.this);
        //a partir de agora o texto será atualizado a cada nova posicao do usuario
        gpsController.atualizarCampoTexto(posicaoTexto);
        gpsController.atualizaGPS();

        configuraMapaOSM();
        registraEventos();

    }



    private void configuraMapaOSM(){
        Configuration.getInstance().setUserAgentValue("saulocabral");

        //uso de zoom com mult. dedos
        mapa.setMultiTouchControls(true);

        controllerMapa = mapa.getController();
        controllerMapa.animateTo(new GeoPoint(gpsController.getLat(),gpsController.getLng()));
        controllerMapa.zoomTo(18,1L);
        gpsController.addControleMapa(controllerMapa);
    }

    public void requisitaPermissoes(){
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_NETWORK_STATE},0);
    }

    private void registraEventos(){
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acessoSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(acessoSettings);
            }
        });

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=-20.513082,-43.716638"));
                startActivity(intent);



            }
        });
    }


}