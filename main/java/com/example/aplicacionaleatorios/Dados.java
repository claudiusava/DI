package com.example.aplicacionaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Dados extends AppCompatActivity implements View.OnClickListener{

    private Button bTirada;
    private ImageView iDados;
    int[] array_dados = {R.drawable.dado_uno, R.drawable.dado_dos, R.drawable.dado_tres, R.drawable.dado_cuatro, R.drawable.dado_cinco, R.drawable.dado_seis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        instancias();
        acciones();
    }

    private void acciones() {
        bTirada.setOnClickListener(this);
    }


    private void instancias(){
        bTirada = findViewById(R.id.boton_tirada);
        iDados = findViewById(R.id.imagen_dado);
    }



    @Override
    public void onClick(View view) {
       if(view == bTirada){
           int aleatorio = (int) (Math.random()*6);
           iDados.setImageDrawable(getResources().getDrawable(array_dados[aleatorio], null));
           iDados.setImageResource(array_dados[aleatorio]);
       }
    }
}
