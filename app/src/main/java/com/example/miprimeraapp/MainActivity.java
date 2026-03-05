package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;


    Double valoresArea[] = {0.0929, 0.6989, 0.8361, 1.0, 436.81, 6988.96, 10000.0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tbh = findViewById(R.id.tbhParcial);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("Agua").setContent(R.id.tabAgua).setIndicator("AGUA"));
        tbh.addTab(tbh.newTabSpec("Area").setContent(R.id.tabArea).setIndicator("ÁREA"));


        findViewById(R.id.btnAguaCalcular).setOnClickListener(v -> calcularPagoAgua());
        findViewById(R.id.btnAreaConvertir).setOnClickListener(v -> calcularArea());
    }


    private void calcularPagoAgua() {
        try {
            EditText txtConsumo = findViewById(R.id.txtAguaConsumo);
            TextView lblTotal = findViewById(R.id.lblAguaTotal);

            double m3 = Double.parseDouble(txtConsumo.getText().toString());
            double total = 0;


            if (m3 <= 18) {
                total = 6.00;
            }

            else if (m3 <= 28) {
                total = 6.00 + ((m3 - 18) * 0.45);
            }

            else {

                total = 10.50 + ((m3 - 28) * 0.65);
            }

            lblTotal.setText("Total a Pagar: $" + String.format("%.2f", total));
        } catch (Exception e) {
            Toast.makeText(this, "Por favor ingrese los metros consumidos", Toast.LENGTH_SHORT).show();
        }
    }


    private void calcularArea() {
        try {
            Spinner spnDe = findViewById(R.id.spnAreaDe);
            Spinner spnA = findViewById(R.id.spnAreaA);
            EditText txtCant = findViewById(R.id.txtAreaCantidad);
            TextView lblRes = findViewById(R.id.lblAreaRespuesta);

            double cantidad = Double.parseDouble(txtCant.getText().toString());
            int de = spnDe.getSelectedItemPosition();
            int a = spnA.getSelectedItemPosition();


            double resultado = (cantidad * valoresArea[de]) / valoresArea[a];

            lblRes.setText("Resultado: " + String.format("%.4f", resultado));
        } catch (Exception e) {
            Toast.makeText(this, "Por favor ingrese una cantidad a convertir", Toast.LENGTH_SHORT).show();
        }
    }
}