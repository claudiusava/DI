package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    boolean decimal = false;
    boolean sum = false;
    boolean res = false;
    boolean mul = false;
    boolean div  = false;
    /*
    boolean raiz = false;
    boolean sin = false;
    boolean cos = false;
    boolean tan = false;
     */

    Double[] numero = new Double[20];
    Double dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Cero = (Button)findViewById(R.id.Cero);
        Cero.setOnClickListener(this);

        Button Uno = (Button)findViewById(R.id.Uno);
        Uno.setOnClickListener(this);

        Button Dos = (Button)findViewById(R.id.Dos);
        Dos.setOnClickListener(this);

        Button Tres = (Button)findViewById(R.id.Tres);
        Tres.setOnClickListener(this);

        Button Cuatro = (Button)findViewById(R.id.Cuatro);
        Cuatro.setOnClickListener(this);

        Button Cinco = (Button)findViewById(R.id.Cinco);
        Cinco.setOnClickListener(this);

        Button Seis = (Button)findViewById(R.id.Seis);
        Seis.setOnClickListener(this);

        Button Siete = (Button)findViewById(R.id.Siete);
        Siete.setOnClickListener(this);

        Button Ocho = (Button)findViewById(R.id.Ocho);
        Ocho.setOnClickListener(this);

        Button Nueve = (Button)findViewById(R.id.Nueve);
        Nueve.setOnClickListener(this);

        Button Igual = (Button)findViewById(R.id.Igual);
        Igual.setOnClickListener(this);

        Button Suma = (Button)findViewById(R.id.Suma);
        Suma.setOnClickListener(this);

        Button Resta = (Button)findViewById(R.id.Resta);
        Resta.setOnClickListener(this);

        Button Multiplicacion = (Button)findViewById(R.id.Multiplicacion);
        Multiplicacion.setOnClickListener(this);

        Button Division = (Button)findViewById(R.id.Division);
        Division.setOnClickListener(this);

        Button Borrar = (Button)findViewById(R.id.Borrar);
        Borrar.setOnClickListener(this);

        Button C = (Button)findViewById(R.id.C);
        C.setOnClickListener(this);

        Button Punto = (Button)findViewById(R.id.Punto);
        Punto.setOnClickListener(this);

        /*
        Button Raiz = (Button)findViewById(R.id.RaizCuadrada);
        Raiz.setOnClickListener(this);

        Button Sin = (Button)findViewById(R.id.Seno);
        Raiz.setOnClickListener(this);

        Button Cos = (Button)findViewById(R.id.Coseno);
        Raiz.setOnClickListener(this);

        Button Tan = (Button)findViewById(R.id.Tangente);
        Raiz.setOnClickListener(this);
         */



    }
    @Override
    public void onClick(View v){
        TextView Pantalla = (TextView)findViewById(R.id.Pantalla);
        int selector = v.getId();
        String x = Pantalla.getText().toString();
        try {
        switch (selector){
            case R.id.Cero:
                Pantalla.setText(x+"0");
                break;

            case R.id.Uno:
                Pantalla.setText(x+"1");
                break;

            case R.id.Dos:
                Pantalla.setText(x+"2");
                break;

            case R.id.Tres:
                Pantalla.setText(x+"3");
                break;

            case R.id.Cuatro:
                Pantalla.setText(x+"4");
                break;

            case R.id.Cinco:
                Pantalla.setText(x+"5");
                break;

            case R.id.Seis:
                Pantalla.setText(x+"6");
                break;

            case R.id.Siete:
                Pantalla.setText(x+"7");
                break;

            case R.id.Ocho:
                Pantalla.setText(x+"8");
                break;

            case R.id.Nueve:
                Pantalla.setText(x+"9");
                break;

            case R.id.Punto:
                if(decimal == false){
                    Pantalla.setText(x+".");
                    decimal = true;
                }else {
                    return;
                }
                break;


            case R.id.Igual:
                numero[1] = Double.parseDouble(x);
                if(sum==true){
                    dato =numero[0]+numero[1];
                    Pantalla.setText(String.valueOf(dato));
                }else if(res==true){
                    dato =numero[0]-numero[1];
                    Pantalla.setText(String.valueOf(dato));
                }else if(mul==true){
                    dato =numero[0]*numero[1];
                    Pantalla.setText(String.valueOf(dato));
                }else if (div==true){
                    dato =numero[0]/numero[1];
                    Pantalla.setText(String.valueOf(dato));
                }
                /*
                else if (raiz == true){
                    Pantalla.setText(String.valueOf(dato));
                }else if (sin == true){
                    Pantalla.setText(String.valueOf(dato));
                }else if (cos == true){
                    Pantalla.setText(String.valueOf(dato));
                }else if (tan == true){
                    Pantalla.setText(String.valueOf(dato));
                }
                 */





                decimal = false;
                sum = false;
                res = false;
                mul = false;
                div = false;
                /*
                raiz = false;
                sin = false;
                cos = false;
                tan = false;
                 */

                break;

            case R.id.Suma:
                sum = true;
                numero [0] = Double.parseDouble(x);
                decimal = false;
                Pantalla.setText("");
                break;

            case R.id.Resta:
                res = true;
                numero [0] = Double.parseDouble(x);
                decimal = false;
                Pantalla.setText("");
                break;

            case R.id.Multiplicacion:
                mul = true;
                numero [0] = Double.parseDouble(x);
                decimal = false;
                Pantalla.setText("");
                break;

            /*
            case R.id.RaizCuadrada:
                raiz = true;
                dato = Math.sqrt(numero[0]);
                decimal = false;
                Pantalla.setText("");

            case R.id.Seno:
                sin = true;
                dato = Math.sin(numero[0]);
                decimal = false;
                Pantalla.setText("");

            case R.id.Coseno:
                cos = true;
                dato = Math.sin(numero[0]);
                decimal = false;
                Pantalla.setText("");

            case R.id.Tangente:
                tan = true;
                dato = Math.sin(numero[0]);
                decimal = false;
                Pantalla.setText("");
             */


            case R.id.Borrar:
                Pantalla.setText("");
                break;

            case R.id.C:
                Pantalla.setText("");
                decimal = false;
                break;

        }
        }catch (Exception e){
            Pantalla.setText("error");
        }
    }

}
