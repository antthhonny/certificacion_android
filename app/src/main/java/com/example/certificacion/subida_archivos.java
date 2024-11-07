package com.example.certificacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class subida_archivos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Mostrar el mensaje Toast al iniciar la actividad
        Toast.makeText(subida_archivos.this, "Vista Subida de Archivos", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.subida_archivos);

        // Referencia al botón Bt_regresar2
        Button btnRegresar2 = findViewById(R.id.Btregresar2);

        // Configurar el evento para regresar al Activity 2 (menu)
        btnRegresar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mostrar mensaje Toast indicando que se está regresando
                Toast.makeText(subida_archivos.this, "Regresando al menú principal...", Toast.LENGTH_SHORT).show();

                // Intent para volver al Activity 2 (menu)
                Intent intent = new Intent(subida_archivos.this, menu.class);
                startActivity(intent);

                // Finaliza el Activity actual para que no quede en la pila
                finish();
            }
        });
        // Referencia al botón Bt_Subida_Archivos para ir a la actividad subida_archivos
        Button btnSiguiente = findViewById(R.id.Btcamara);

        // Configurar el evento para ir al Activity 3 (subida_archivos)
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subida_archivos.this,camara.class);
                startActivity(intent);
            }
        });

        Button btnSiguiente3 = findViewById(R.id.Bt_infomacion);

        // Configurar el evento para ir al Activity 3 (subida_archivos)
        btnSiguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subida_archivos.this,informacion.class);
                startActivity(intent);
            }
        });

        Button btnSiguiente4 = findViewById(R.id.Bt_datosf);

        // Configurar el evento para ir al Activity 3 (subida_archivos)
        btnSiguiente4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subida_archivos.this,datos_firebase.class);
                startActivity(intent);
            }
        });

    }
}
