package com.example.ltpsqllitecomercio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnInsertar,btnConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertar = findViewById(R.id.btnInsertar);
        btnConsultar = findViewById(R.id.btnConsultar);
    }
    public void llamarConsultarUsuario(View view) {
        Intent i = new Intent(this, ConsultarUsuario.class);
        startActivity(i);
    }

    public void LlamarInsertar(View view) {
        Intent intent = new Intent(this, InsertarUsuario.class);
        startActivity(intent);
    }

    public void listarUsuarioSpinner(View view) {
        Intent intent = new Intent(this, ListarUsersSpinners.class);
        startActivity(intent);
    }

    public void listarUsuario(View view) {
        Intent intent = new Intent(this, ListarUsuarios.class);
        startActivity(intent);
    }
}