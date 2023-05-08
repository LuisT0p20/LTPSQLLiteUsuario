package com.example.ltpsqllitecomercio;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ltpsqllitecomercio.Entidades.Usuario;
import com.example.ltpsqllitecomercio.utils.ConexionSqlHelper;
import com.example.ltpsqllitecomercio.utils.Utilidades;

import java.util.ArrayList;

public class ListarUsersSpinners extends AppCompatActivity {
    Spinner cmbPersonas;
    TextView txtId, txtNom, txtTel;
    ArrayList<String> listaUsuarios;
    ArrayList<Usuario> UsuariosList;
    ConexionSqlHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_users_spinners);
        cmbPersonas = findViewById(R.id.cmbUsuarios);
        txtId = findViewById(R.id.txtDocumento);
        txtNom = findViewById(R.id.txtNombre);
        txtTel = findViewById(R.id.txtTelefono);
        conn = new ConexionSqlHelper(this, Utilidades.NOMBREBD, null, Utilidades.VERSION);
        consultarUsuarios();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaUsuarios);
        cmbPersonas.setAdapter(adaptador);
        cmbPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position !=0) {
                    txtId.setText(UsuariosList.get(position - 1).getId().toString());
                    txtNom.setText(UsuariosList.get(position - 1).getNombre().toString());
                    txtTel.setText(UsuariosList.get(position - 1).getTelefono().toString());
                }
                else{
                    txtId.setText("");
                    txtNom.setText("");
                    txtTel.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    private void consultarUsuarios() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Usuario usuario = null;
        UsuariosList = new ArrayList<Usuario>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);
        while (cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));
            Log.i("id",usuario.getId().toString());
            Log.i("Nombre",usuario.getNombre().toString());
            Log.i("Telefono",usuario.getTelefono().toString());
            UsuariosList.add(usuario);
        }
        obtenerListaUsuarios();
    }

    private void obtenerListaUsuarios() {
        listaUsuarios = new ArrayList<String>();
        listaUsuarios.add("Seleccione");
        for (int i = 0; i < UsuariosList.size(); i++){
            listaUsuarios.add(UsuariosList.get(i).getId() + " - " + UsuariosList.get(i).getNombre() + " - " + UsuariosList.get(i).getTelefono());
        }
    }
}