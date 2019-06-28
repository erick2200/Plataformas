package com.example.agendadeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    private EditText v_nombre,v_direccion,v_email,v_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        v_nombre =  (EditText) findViewById(R.id.txt_e_nombre);
        v_direccion = (EditText) findViewById(R.id.txt_e_dir);
        v_email = (EditText) findViewById(R.id.txt_e_mail);
        v_phone = (EditText) findViewById(R.id.txt_e_phone);

        getSupportActionBar().setTitle("Registro de cliente");

    }

    public void registrar(View view)
    {
        AdminDataBase conexion =  new AdminDataBase(this,"Agenda",null,1);
        SQLiteDatabase database = conexion.getWritableDatabase();

        String nombre = v_nombre.getText().toString();
        String direccion = v_direccion.getText().toString();
        String email = v_email.getText().toString();
        String phone = v_phone.getText().toString();

        if(nombre.isEmpty() || direccion.isEmpty() || email.isEmpty() || phone.isEmpty()){
            Toast.makeText(this, "Debe de rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            ContentValues objeto = new ContentValues();
            objeto.put("NOMBRE",nombre);
            objeto.put("DIRECCION",direccion);
            objeto.put("EMAIL",email);
            objeto.put("TELEFONO",phone);

            database.insert("CLIENTE",null,objeto);

            database.close();

            v_phone.setText("");
            v_email.setText("");
            v_direccion.setText("");
            v_nombre.setText("");

            Toast.makeText(this, "Registro realizado exitosamente", Toast.LENGTH_SHORT).show();
        }

    }

    public void regresar(View view)
    {
        finish();
    }

}
