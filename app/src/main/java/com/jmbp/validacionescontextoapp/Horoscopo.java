package com.jmbp.validacionescontextoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Horoscopo extends AppCompatActivity {
    TextView tvResultado;
    Button btRegresar, btSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscopo);
        tvResultado = findViewById(R.id.txtMensaje);
        btRegresar = findViewById(R.id.btnRegresar);
        btSalir = findViewById(R.id.btnSalir);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            String signo = parametros.getString("SignoZodiacal");
            String mensaje = horoscopo(signo);
            tvResultado.setText(mensaje);
            Toast.makeText(Horoscopo.this, mensaje, Toast.LENGTH_LONG).show();
        }

        // Asigna los listeners a los botones
        btRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });

        btSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salir();
            }
        });
    }

    public String horoscopo(String signo) {
        if (!signo.isEmpty()) {
            if (signo.equalsIgnoreCase("Aries")) {
                return "El día de hoy te vas a ganar la lotería";
            } else {
                return "Ingrese un Signo Zodiacal válido";
            }
        } else {
            return "Ingrese un Signo Zodiacal";
        }
    }

    public void salir() {
        this.onDestroy();
    }

    public void regresar() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}