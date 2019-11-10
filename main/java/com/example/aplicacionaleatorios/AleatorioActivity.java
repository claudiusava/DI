package com.example.aplicacionaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class AleatorioActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    ImageButton btncohete;
    CheckBox permitirdecimales;
    RadioGroup gruporadios;
    Switch repetir;
    EditText decimalesmin, decimalesmax, numdecimales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        instancias();
        acciones();
    }

    private void acciones() {

        btncohete.setOnClickListener(this); //accion del boton
        permitirdecimales.setOnCheckedChangeListener(this); //acciones del Checkbox
        repetir.setOnCheckedChangeListener(this); //acciones del Switch
        gruporadios.setOnCheckedChangeListener(this); //acciones del grupo de radios
    }

    private void instancias() {

        btncohete = findViewById(R.id.btncohete);
        permitirdecimales = findViewById(R.id.checkpermitirdecimales);
        gruporadios = findViewById(R.id.grupodecimales);
        repetir = findViewById(R.id.switchrepetir);
        decimalesmin = findViewById(R.id.decimalminimo);
        decimalesmax = findViewById(R.id.decimalmaximo);
        numdecimales = findViewById(R.id.num_decimales);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int i) {

        switch (gruporadios.getCheckedRadioButtonId()){
            case R.id.radio_sin_rango:
                decimalesmax.setEnabled(false);
                decimalesmin.setEnabled(false);
                break;

            case R.id.radio_con_rango:
                decimalesmax.setEnabled(true);
                decimalesmin.setEnabled(true);
                break;
        }

    }




    @Override
    public void onClick(View v) {

    }





        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b){
                numdecimales.setEnabled(true);
            }else {
                numdecimales.setEnabled(false);
            }


    }
}