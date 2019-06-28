package com.example.agendadeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarActivity extends AppCompatActivity {

    private EditText v_numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        getSupportActionBar().setTitle("Eliminar cliente");

        v_numero = (EditText) findViewById(R.id.txt_num_supr);

    }

    public void eliminar(View view)
    {
        String numero = v_numero.getText().toString();

        AdminDataBase conexion = new AdminDataBase(this,"Agenda",null,1);
        SQLiteDatabase database = conexion.getWritableDatabase();

        if(numero.isEmpty()){
            Toast.makeText(this, "Debe ingresar el numero", Toast.LENGTH_SHORT).show();
        }else{
            int result = database.delete("CLIENTE","TELEFONO=" + numero,null);
            database.close();

            if(result == 1) {
                Toast.makeText(this, "Cliente eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No se pudo elimar cliente", Toast.LENGTH_SHORT).show();
            }

        }


    }

    public void regresar(View view)
    {
        finish();
    }

}
