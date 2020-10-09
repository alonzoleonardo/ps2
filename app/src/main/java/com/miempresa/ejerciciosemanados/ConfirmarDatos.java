package com.miempresa.ejerciciosemanados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_datos);

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvFecha = findViewById(R.id.tvFecha);
        TextView tvTelefono = findViewById(R.id.tvTelefono);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvDescripcion = findViewById(R.id.tvDescripcion);
        Button btnEdit = findViewById(R.id.btnEdit);

        Bundle params = getIntent().getExtras();
        String nombre = params.getString("nombre");
        String fecha = params.getString("fecha");
        String telefono = params.getString("telefono");
        String email = params.getString("email");
        String descripcion = params.getString("descripcion");

        tvNombre.setText("Nombre: " + nombre);
        tvFecha.setText("Fecha: " + fecha);
        tvTelefono.setText("Teléfono: " + telefono);
        tvFecha.setText("Fecha: " + fecha);
        tvEmail.setText("Email: " + email);
        tvDescripcion.setText("Descripción: " + descripcion);

        btnEdit.setOnClickListener((v) -> {
            backButton();
        });

    }

    private void backButton(){
        onBackPressed();
    }
}