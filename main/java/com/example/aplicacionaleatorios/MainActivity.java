package com.example.aplicacionaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton bAleatorio, bNombresAleatorios, bDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        bAleatorio.setOnClickListener(this);
        bNombresAleatorios.setOnClickListener(this);
        bDados.setOnClickListener(this);
    }

    private void instancias() {
        bAleatorio = findViewById(R.id.boton_aleatorio);
        bNombresAleatorios = findViewById(R.id.boton_nombres);
        bDados= findViewById(R.id.boton_dados);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.boton_aleatorio:
                intent = new Intent(getApplicationContext(), com.example.aplicacionaleatorios.AleatorioActivity.class);
                break;

            case R.id.boton_nombres:
                intent = new Intent(getApplicationContext(), com.example.aplicacionaleatorios.NombresAleatorios.class);
                break;

            case R.id.boton_dados:
                intent = new Intent(getApplicationContext(), com.example.aplicacionaleatorios.Dados.class);
                break;
        }
        startActivity(intent);
    }
}
