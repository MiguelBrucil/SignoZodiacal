package com.jmbp.validacionescontextoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edSignoZodiacal;
Button btIr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSignoZodiacal = findViewById((R.id.txtSigno));
        btIr=findViewById(R.id.btnConsultar);
        btIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signo = edSignoZodiacal.getText().toString();
                Bundle parametrosEnvio=new Bundle();
                parametrosEnvio.putString("SignoZodiacal",signo);
                Intent intent=new Intent(MainActivity.this, Horoscopo.class);
                intent.putExtras(parametrosEnvio);
                startActivity(intent);

            }
        });




    }
}