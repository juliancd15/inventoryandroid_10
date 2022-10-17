package com.example.inventoryandroid_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AgregarProductoActivity extends AppCompatActivity {

    // Se declaran variables
    private EditText nombreProducto, precioProductoUnidad, cantidadProducto, ventaProducto, getPrecioProductoConjunto;
    private Spinner spinnertipo;
    private int contador=0, cantidad; // variable contador, cuenta de los productos ingresados
    private String nombre, tipo, seleccion;
    private double precioUnidad, ventaUnidad, precioConjunto;
    private ArrayList<Producto> productos = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        cargarProducto();
        nombreProducto = (EditText) findViewById(R.id.e_nombreproducto);
        precioProductoUnidad = (EditText) findViewById(R.id.e_preciounidad);
        cantidadProducto = (EditText) findViewById(R.id.e_cantidad);
        ventaProducto = (EditText) findViewById(R.id.e_ventaunidad);
        getPrecioProductoConjunto = (EditText) findViewById(R.id.e_precioconjunto);
        spinnertipo = (Spinner) findViewById(R.id.spinner);
        String[] opciones= {"Limpieza", "Farmacia", "Consumo diario", "Desechables"};
        ArrayAdapter<String> arreglo1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinnertipo.setAdapter(arreglo1); // todas las opciones se van agregar al spinner

    }

    public void agregar(View view){
        // se castean las variables - cambiar el tipo de variable a otra
        nombre = nombreProducto.getText().toString();
        ventaUnidad = Double.parseDouble(ventaProducto.getText().toString());
        cantidad = Integer.parseInt(cantidadProducto.getText().toString());
        precioUnidad = Double.parseDouble(precioProductoUnidad.getText().toString());
        precioConjunto = Double.parseDouble(getPrecioProductoConjunto.getText().toString());
        seleccion = spinnertipo.getSelectedItem().toString();

        //Se añade un producto con las siguienets variables
        productos.add(contador,new Producto(nombre,seleccion,cantidad,precioUnidad,ventaUnidad,precioConjunto));
        contador+=1; // al contador se le suma un, que es el producto agregado
        guardarProducto();
        Toast.makeText(this, "Producto agregado", Toast.LENGTH_SHORT).show();

    }

    public void guardarProducto(){
        try {

            FileOutputStream fos = openFileOutput("productos.dat", Context.MODE_PRIVATE); //Se guarda en product.dat
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productos);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
            }
    }

    public void cargarProducto(){
        try {
            FileInputStream fin = openFileInput("productos.dat");
            ObjectInputStream oin = new ObjectInputStream(fin);
            productos = (ArrayList<Producto>) oin.readObject();
            oin.close();
            contador = productos.size()-1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
