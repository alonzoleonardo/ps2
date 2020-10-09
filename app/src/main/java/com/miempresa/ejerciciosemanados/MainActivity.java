package com.miempresa.ejerciciosemanados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etFecha, etTelefono, etEmail, etDescripcion;
    private Button btnSiguiente;
    private DatePickerDialog.OnDateSetListener DateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etFecha  = findViewById(R.id.etFecha);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener((v) -> {
            btnSiguienteClick();
        });

        etFecha.setOnClickListener((View v) -> {
            fechaClick();
        });

        DateListener = (datePicker, ano, mes, dia) -> {
            mes = mes + 1;
            String fecha = dia + "/" + mes + "/" + ano;
            etFecha.setText(fecha);
        };
    }

    private void fechaClick(){
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog date = new DatePickerDialog(MainActivity.this,
                android.R.style.Theme_Material_Dialog_MinWidth,
                DateListener, ano, mes, dia);
        date.show();
    }

    private void btnSiguienteClick(){
        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
        intent.putExtra("nombre", etNombre.getText().toString());
        intent.putExtra("fecha", etFecha.getText().toString());
        intent.putExtra("telefono", etTelefono.getText().toString());
        intent.putExtra("email", etEmail.getText().toString());
        intent.putExtra("descripcion", etDescripcion.getText().toString());
        startActivity(intent);
    }
}