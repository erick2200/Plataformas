package com.example.agendadeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }

    public void registrar(View view)
    {
        Intent intent = new Intent(this,RegistrarActivity.class);
        startActivity(intent);
    }

    public void mostrar(View view)
    {
        Intent intent = new Intent(this,MostrarActivity.class);
        startActivity(intent);
    }

    public void modificar(View view)
    {
        Intent intent = new Intent(this,EditarActivity.class);
        startActivity(intent);
    }

    public void eliminar(View view)
    {
        Intent intent = new Intent(this, EliminarActivity.class);
        startActivity(intent);
    }

}
