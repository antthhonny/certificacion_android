package com.example.certificacion;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class datos_firebase extends AppCompatActivity {

    private EditText editTextItemNombre, editTextDescription, editTextQuantity;
    private Button btnSave, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_firebase);

        // Inicializa las vistas
        editTextItemNombre = findViewById(R.id.editTextItemName);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        btnSave = findViewById(R.id.btnSave);
        btnRegresar = findViewById(R.id.btregresar5); // Mover aquí la inicialización de btnRegresar

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recoger valores de los EditText
                String itemName = editTextItemNombre.getText().toString().trim();
                String description = editTextDescription.getText().toString().trim();
                String quantity = editTextQuantity.getText().toString().trim();

                if (TextUtils.isEmpty(itemName) || TextUtils.isEmpty(description) || TextUtils.isEmpty(quantity)) {
                    Toast.makeText(datos_firebase.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Referencia a Firebase
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("items");

                    String itemsId = databaseReference.push().getKey();

                    // Crear objeto Item con los tres campos
                    Item item = new Item(itemName, description, quantity);

                    if (itemsId != null) {
                        databaseReference.child(itemsId).setValue(item)
                                .addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(datos_firebase.this, "El elemento se agregó con éxito", Toast.LENGTH_SHORT).show();
                                        // Limpia los campos después de guardar
                                        editTextItemNombre.setText("");
                                        editTextDescription.setText("");
                                        editTextQuantity.setText("");
                                    } else {
                                        Toast.makeText(datos_firebase.this, "Fallo el ingreso", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }
            }
        });

        // Configurar el evento para regresar al MainActivity
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje Toast
                Toast.makeText(datos_firebase.this, "Regresando al menú principal...", Toast.LENGTH_SHORT).show();
                // Intent para volver al MainActivity
                Intent intent = new Intent(datos_firebase.this, menu.class);
                startActivity(intent);
                finish(); // Finaliza el Activity actual
            }
        });
    }
}
