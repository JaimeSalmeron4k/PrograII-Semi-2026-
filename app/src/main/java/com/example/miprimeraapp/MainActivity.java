package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    RadioButton opt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(v ->calcular());
    }
    private void calcular(){
        tempVal = findViewById(R.id.txtNum1);
        double num1 = Double.parseDouble(tempVal.getText().toString());

        tempVal = findViewById(R.id.txtNum2);
        double num2 = Double.parseDouble(tempVal.getText().toString());

        double respuesta = 0;

        opt = findViewById(R.id.optSuma);
        if(opt.isChecked()) {
            respuesta = num1 + num2;
        }
        opt = findViewById(R.id.optResta);
        if(opt.isChecked()) {
            respuesta = num1 - num2;
        }
        opt = findViewById(R.id.optMultiplicar);
        if(opt.isChecked()) {
            respuesta = num1 * num2;
        }
        opt = findViewById(R.id.optDivision);
        if(opt.isChecked()) {
            respuesta = num1 / num2;
        }
        opt = findViewById(R.id.optFactorial);
        if(opt.isChecked()) {
            int limite = (int) num1;
            double acumulador = 1;
            for (int i = 1; i <= limite; i++) {
                acumulador = acumulador * i;
                respuesta = acumulador;
            }
        }
        opt = findViewById(R.id.optPorcentaje);
        if(opt.isChecked()) {
            respuesta = (num1 * num2) /100;
        }
            opt = findViewById(R.id.optExponenciacion);
            if(opt.isChecked()) {
                double base = num1;
                double exponente = num2;
                respuesta = Math.pow(base, exponente);
        }
        opt = findViewById(R.id.optRaiz);
        if(opt.isChecked()) {
            respuesta = Math.sqrt(num1);
        }

        tempVal = findViewById(R.id.lblRespuesta);
        tempVal.setText("Respuesta: "+ respuesta);
    }
}