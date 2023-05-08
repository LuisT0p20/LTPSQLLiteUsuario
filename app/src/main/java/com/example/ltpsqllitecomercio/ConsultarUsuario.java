package com.example.ltpsqllitecomercio;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ltpsqllitecomercio.utils.ConexionSqlHelper;
import com.example.ltpsqllitecomercio.utils.Utilidades;

public class ConsultarUsuario extends AppCompatActivity implements View.OnClickListener {
    EditText edtId, edtNom,edtTel;
    Button btnBuscar;
    ConexionSqlHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);
        edtId = findViewById(R.id.edtCUid);
        edtNom = findViewById(R.id.edtCUnombre);
        edtTel = findViewById(R.id.edtCUTel);
        btnBuscar = findViewById(R.id.btnCUconsulUsuario);
        btnBuscar.setOnClickListener(this);
        conn = new ConexionSqlHelper(this, Utilidades.NOMBREBD, null,Utilidades.VERSION );
    }

    @Override
    public void onClick(View v) {
        consultar();
    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {edtId.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};
        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?", parametros, null, null, null);
            cursor.moveToFirst();
            edtNom.setText(cursor.getString(0));
            edtTel.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(this, "El registro no existe", Toast.LENGTH_SHORT).show();
        }
    }
}