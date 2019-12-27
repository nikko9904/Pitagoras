package com.example.pitagoras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    Button calcular;
    Button limpiar;
    EditText teA;
    EditText teB;
    CheckBox hipo;
    TextView resultado;

    String cateto_a;
    String cateto_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcular =  findViewById(R.id.btnCalcular);
        teA =  findViewById(R.id.edtxtA);
        teB =  findViewById(R.id.edtxtB);
        resultado = findViewById(R.id.txtResultado);
        hipo = findViewById(R.id.esHipotenusa);


        calcular.setOnClickListener( v -> {
            cateto_b = teB.getText().toString();
            cateto_a = teA.getText().toString();

            float a = Float.valueOf(cateto_a);
            float b = Float.valueOf(cateto_b);
            double c = 0;

            if(hipo.isChecked()){
                c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                resultado.setText(String.valueOf(c));
            }
            else{
                c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
                resultado.setText(String.valueOf(c));
            }

            if(a == b & b==c & a==c) {

                Toast.makeText(this, "Equilatero", Toast.LENGTH_LONG).show();
            }

            if( a == b & b == c & a!=c ) {
                Toast.makeText(this, "Iisoseles", Toast.LENGTH_LONG).show();
            }

            if( a != b & b!= c & c != a) {
                Toast.makeText(this, "Escaleno", Toast.LENGTH_LONG).show();
            }
        });

    }

}