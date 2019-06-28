package com.example.agendadeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MostrarActivity extends AppCompatActivity {

    private ListView listView;
    private TextView salida;

    private ArrayList<String> nombres;
    private ArrayList<String> direcciones;
    private ArrayList<String> emails;
    private ArrayList<String> telefonos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        getSupportActionBar().setTitle("Mostrar de clientes");

        AdminDataBase conexion = new AdminDataBase(this,"Agenda",null,1);
        SQLiteDatabase database = conexion.getWritableDatabase();

        listView = (ListView) findViewById(R.id.listView);
        salida = (TextView) findViewById(R.id.txt_cliente);

        nombres = new ArrayList<String>();
        direcciones = new ArrayList<String>();
        emails =  new ArrayList<String>();
        telefonos = new ArrayList<String>();


        String sql = "SELECT * FROM CLIENTE";

        Cursor cliente = database.rawQuery(sql,null);

        if(cliente.getCount() > 0){
            cliente.moveToFirst();
            do{
                nombres.add(cliente.getString(cliente.getColumnIndex("NOMBRE")));
                direcciones.add(cliente.getString(cliente.getColumnIndex("DIRECCION")));
                emails.add(cliente.getString(cliente.getColumnIndex("EMAIL")));
                telefonos.add(cliente.getString(cliente.getColumnIndex("TELEFONO")));
            }
            while (cliente.moveToNext());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_clients,nombres);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nombre = nombres.get(i) ;
                String direccion = direcciones.get(i);
                String email = emails.get(i);
                String numero = telefonos.get(i);
                salida.setText("Nombre: " + nombre  + "\n" + "Direccion: " + direccion + "\n" + "Email: " + email + "\n" + "Numero: " + numero);
            }
        });

    }
}
