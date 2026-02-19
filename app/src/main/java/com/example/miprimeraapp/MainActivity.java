package com.example.miprimeraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tempVal;
    Spinner spn;
    Button btn;
    Double valores[][] = {
            {1.0, 0.85, 7.67, 26.42, 36.80, 495.77}, //monedas
            {1.0, 1000.0, 100.0, 39.3701, 3.280841666667, 1.1963081929167, 1.09361}, //longitud
            {1.0, 1000.0, 0.001, 1000.0, 0.264172, 0.219969, 33.814, 2.1138, 1.05669, 0.00628981}, //volumen
            {
                    1.0,           // Kilogramo (kg) - unidad base
                    1000.0,        // Gramo (g)
                    1000000.0,     // Miligramo (mg)
                    100.0,         // Decagramo (dag)
                    10.0,          // Hectogramo (hg)
                    5000.0,        // Quilate (ct) - 1 kg = 5000 ct
                    35.274,        // Onza (oz)
                    2.20462,       // Libra (lb)
                    0.157473,      // Stone (st)
                    0.001          // Tonelada (t)
            }, // Masa
            {
                    1.0,           // Bit (b)
                    0.125,         // Byte (B)
                    0.000125,      // Kilobyte (KB)
                    1.25e-7,       // Megabyte (MB)
                    1.25e-10,      // Gigabyte (GB)
                    1.25e-13,      // Terabyte (TB)
                    1.25e-16,      // Petabyte (PB)
                    1.25e-19,      // Exabyte (EB)
                    1.25e-22,      // Zettabyte (ZB)
                    1.25e-25       // Yottabyte (YB)
            }, // Almacenamiento
    };
    String[][] etiquetas = {
            {"Dolar", "Euro", "Quetzal", "Lempira", "Cordoba", "Colon CR"}, //monedas
            {"Mts", "Ml", "Cm", "Pulgada", "Pies", "Vara", "Yarda"}, //Longitud
            {"Litro (L)", "Mililitro (mL)", "Metro cúbico (m³)", "Centímetro cúbico (cm³)", "Galón estadounidense (gal US)", "Galón imperial (gal UK)",
                    "Onza líquida (fl oz)", "Pinta (pt)", "Cuarto (qt)", "Barril (bbl)"},  //volumen
            {"Kilogramo (kg)", "Gramo (g)", "Miligramo (mg)", "Decagramo (dag)", "Hectogramo (hg)", "Quilate (ct)", "Onza (oz)",
                    "Libra (lb)", "Stone (st)", "Tonelada (t)"}, // Masa
            {"Bit (b)", "Byte (B)", "Kilobyte (KB)", "Megabyte (MB)", "Gigabyte (GB)", "Terabyte (TB)", "Petabyte (PB)", "Exabyte (EB)",
                    "Zettabyte (ZB)", "Yottabyte (YB)"}, // almacenamiento
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(v->convertir());

        cambiarEtiqueta(0);//valores predeterminaods

        spn = findViewById(R.id.spnTipo);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cambiarEtiqueta(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void cambiarEtiqueta(int posicion){
        ArrayAdapter<String> aaEtiquetas = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                etiquetas[posicion]
        );
        aaEtiquetas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn = findViewById(R.id.spnDe);
        spn.setAdapter(aaEtiquetas);

        spn = findViewById(R.id.spnA);
        spn.setAdapter(aaEtiquetas);
    }
    private void convertir(){
        spn = findViewById(R.id.spnTipo);
        int tipo = spn.getSelectedItemPosition();

        spn = findViewById(R.id.spnDe);
        int de = spn.getSelectedItemPosition();

        spn = findViewById(R.id.spnA);
        int a = spn.getSelectedItemPosition();

        tempVal = findViewById(R.id.txtCantidad);
        double cantidad = Double.parseDouble(tempVal.getText().toString());
        double respuesta = conversor(tipo, de, a, cantidad);

        tempVal = findViewById(R.id.lblRespuesta);
        tempVal.setText("Respuesta: "+ respuesta);
    }
    double conversor(int tipo, int de, int a, double cantidad){
        return valores[tipo][a]/valores[tipo][de] * cantidad;
    }
}