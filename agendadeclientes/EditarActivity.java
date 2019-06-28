package com.example.agendadeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarActivity extends AppCompatActivity {

    private EditText v_old_p,v_nombre,v_direccion,v_email,v_new_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        getSupportActionBar().setTitle("Editar cliente");

        v_old_p = (EditText) findViewById(R.id.txt_e_op);
        v_nombre =  (EditText) findViewById(R.id.txt_e_nombre);
        v_direccion = (EditText) findViewById(R.id.txt_e_dir);
        v_email = (EditText) findViewById(R.id.txt_e_mail);
        v_new_p = (EditText) findViewById(R.id.txt_e_phone);
    }

    public void editar(View view)
    {
        AdminDataBase conexion =  new AdminDataBase(this,"Agenda",null,1);
        SQLiteDatabase database = conexion.getWritableDatabase();

        String old_phone = v_old_p.getText().toString();
        String nombre = v_nombre.getText().toString();
        String direccion = v_direccion.getText().toString();
        String email = v_email.getText().toString();
        String phone = v_new_p.getText().toString();

        if(old_phone.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || email.isEmpty() || phone.isEmpty()){
            Toast.makeText(this, "Debe de rellenar todos lo datos", Toast.LENGTH_SHORT).show();
        }else{
            ContentValues contenido = new ContentValues();
            contenido.put("NOMBRE",nombre);
            contenido.put("DIRECCION",direccion);
            contenido.put("EMAIL",email);
            contenido.put("TELEFONO",phone);

            int result = database.update("CLIENTE",contenido,"TELEFONO=" + old_phone ,null );
            database.close();

            if(result == 1 ){
                Toast.makeText(this, "Actualizado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No se pudo actualizar", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void regresar(View view)
    {
        finish();
    }
}
