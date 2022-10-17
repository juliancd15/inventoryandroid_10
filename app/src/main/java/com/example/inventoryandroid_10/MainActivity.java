package com.example.inventoryandroid_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_apellido;
    Button c_guardar,btn_mostrarcliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void agregarProducto(View view){
        Intent agregarProducto = new Intent(this, AgregarProductoActivity.class);
        startActivity(agregarProducto);
    }

    public void AgregarCliente(View view){
        Intent AgregarCliente= new Intent(this, AgregarCliente.class);
        startActivity(AgregarCliente);
    }

    public void agregarProveedor(View view){
        Intent agregarProveedor= new Intent(this, AgregarProveedor.class);
        startActivity(agregarProveedor);
    }

    public void agregarSucursal(View view){
        Intent agregarSucursal= new Intent(this, AgregarSucursal.class);
        startActivity(agregarSucursal);
    }
}