package com.example.ltpsqllitecomercio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ltpsqllitecomercio.Entidades.FormaContacto;
import com.example.ltpsqllitecomercio.utils.ConexionSqlHelper;
import com.example.ltpsqllitecomercio.utils.Utilidades;

import java.util.ArrayList;

public class InsertarUsuario extends AppCompatActivity implements View.OnClickListener {
    EditText edtId,edtNom,edtTel;
    Spinner cmbFormaContacto;
    Button btnInsertar;
    ArrayList<FormaContacto> FormaContactoList;
    ArrayList<String> FormaContactoVer;
    ConexionSqlHelper conn = new ConexionSqlHelper(this, Utilidades.NOMBREBD, null, Utilidades.VERSION);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_usuario);
        edtId = findViewById(R.id.edtIUid);
        edtNom = findViewById(R.id.edtIUnom);
        edtTel = findViewById(R.id.edtIUtele);
        cmbFormaContacto = findViewById(R.id.cmbFormaContacto);
        btnInsertar = findViewById(R.id.btnIUSregusuario);

        btnInsertar.setOnClickListener(this);
        generarFormaContacto();//desde BD
        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter(this, android.R.layout.simple_spinner_item,FormaContactoVer);
        cmbFormaContacto.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,edtId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,edtNom.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,edtTel.getText().toString());
        values.put("idFormaContacto", cmbFormaContacto.getSelectedItemId()+1);
        Long resultado = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);
        Toast.makeText(this, "Id de registro " + resultado, Toast.LENGTH_SHORT).show();
        db.close();
    }
    private void generarFormaContacto() {
        SQLiteDatabase db = conn.getReadableDatabase();
        FormaContacto formaContacto;
        FormaContactoList = new ArrayList<FormaContacto>();
        Cursor cursor = db.rawQuery("SELECT * FROM formaContacto", null);

        while (cursor.moveToNext()){
            formaContacto = new FormaContacto();
            formaContacto.setIdFormaContacto(cursor.getString(0));
            formaContacto.setTipoContacto(cursor.getString(1));
            FormaContactoList.add(formaContacto);
        }
        rellenarFormaContacto();
    }

    private void rellenarFormaContacto() {
        FormaContactoVer = new ArrayList<String>();
        FormaContactoVer.add("Seleccione Forma Contacto");
        for (int i=0; i<FormaContactoList.size(); i++){
            FormaContactoVer.add(FormaContactoList.get(i).getIdFormaContacto() + " - " + FormaContactoList.get(i).getTipoContacto());
        }
    }
}