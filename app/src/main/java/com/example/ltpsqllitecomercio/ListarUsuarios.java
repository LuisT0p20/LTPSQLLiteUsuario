package com.example.ltpsqllitecomercio;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ltpsqllitecomercio.Entidades.Usuario;
import com.example.ltpsqllitecomercio.utils.ConexionSqlHelper;
import com.example.ltpsqllitecomercio.utils.Utilidades;

import java.util.ArrayList;

public class ListarUsuarios extends AppCompatActivity {
    ListView lstusers;
    ConexionSqlHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);
        lstusers = findViewById(R.id.lstUsuarios);
        conn = new ConexionSqlHelper(this, Utilidades.NOMBREBD, null, Utilidades.VERSION);
        consultarListaUsuarios();
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaInformacion);
        lstusers.setAdapter(adaptador);
        lstusers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String informacion="Id: " + listaUsuarios.get(i).getId()+"\n";
                informacion+="Nombre: "+ listaUsuarios.get(i).getNombre()+"\n";
                informacion+="telefono: " + listaUsuarios.get(i).getTelefono()+"\n";
                informacion+="Forma contacto: " + listaUsuarios.get(i).getIdFormaContacto()+"\n";
                Toast.makeText(ListarUsuarios.this, informacion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void consultarListaUsuarios() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Usuario usuario = null;
        listaUsuarios = new ArrayList<Usuario>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);
        while (cursor.moveToNext()){
            usuario= new Usuario( );
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));
            usuario.setIdFormaContacto(cursor.getString(3));
            listaUsuarios.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        for (int i=0; i<listaUsuarios.size(); i++) {
            listaInformacion.add(listaUsuarios.get(i).getId() + " - " + listaUsuarios.get(i).getNombre() + " - " + listaUsuarios.get(i).getTelefono() + " - " + listaUsuarios.get(i).getIdFormaContacto());
        }
    }
}