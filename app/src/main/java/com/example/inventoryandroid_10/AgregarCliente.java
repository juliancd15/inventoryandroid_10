package com.example.inventoryandroid_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregarCliente extends AppCompatActivity {

    EditText c_nombre;
    Spinner c_estado;
    Button c_guardar,btn_mostrarcliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cliente);

        //busqueda de controles
        c_nombre = (EditText) findViewById(R.id.c_nombre);
        c_estado = (Spinner) findViewById(R.id.c_estado);

        c_guardar = (Button) findViewById(R.id.c_guardar);
        btn_mostrarcliente = (Button) findViewById(R.id.btn_mostrarcliente);

        c_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //guardar(c_nombre.getText().toString(),c_estado.getText().toString());
            }
        });

        btn_mostrarcliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, ListadoCliente.class));
            }
        });

    }

    private void guardar(String Nombre, String Apellido){
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues c = new ContentValues();
            //Nomrbe de la tabla
            c.put("Nombre",Nombre);
            c.put("Apellido",Apellido);
            db.insert("PERSONAS",null,c);
            Toast.makeText(this,"Registro insertado",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(this,"Error: " + e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    }
}