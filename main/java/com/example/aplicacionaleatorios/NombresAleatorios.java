package com.example.aplicacionaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class NombresAleatorios extends AppCompatActivity implements View.OnClickListener{

    EditText  nombre;
    TextView concursantes_agregados;
    Button bGanador, bAgregar;
    ArrayList concursantes;
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombres_aleatorios);
        instancias();
        acciones();
    }

    private void acciones(){
        bGanador.setOnClickListener(this);
        bAgregar.setOnClickListener(this);
    }

    private void instancias(){
    bAgregar = findViewById(R.id.boton_agregar);
    bGanador = findViewById(R.id.boton_ganador);
    nombre = findViewById(R.id.nombre);
    concursantes_agregados = findViewById(R.id.concursantes_agregados);
    concursantes = new ArrayList();
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.boton_agregar:
                String con = nombre.getText().toString();
                concursantes.add(posicion, con);
                concursantes_agregados.append(con + "\n");
                nombre.setText("");
                System.out.println(concursantes);
                posicion++;
                break;

            case R.id.boton_ganador:
                int aleatorio = (int)(Math.random()*concursantes.size());
                String prueba = concursantes.get(aleatorio).toString();
                concursantes_agregados.setText("El ganador es: "+prueba+ "\n\n");
                concursantes.clear();
                posicion = 0;
                break;
        }

    }
}
