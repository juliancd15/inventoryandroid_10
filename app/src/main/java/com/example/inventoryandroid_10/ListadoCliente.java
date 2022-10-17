package com.example.inventoryandroid_10;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoCliente extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_cliente);
        //listView = (ListView) findViewById(R.id.listview);

    }

    private void CargarListado(){
        listado = ListaPersonas();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listado);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> ListaPersonas(){
        ArrayList<String> datos = new ArrayList<String>();
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select ID,NOMBRE, APELLIDO from personas";
        Cursor c = db.rawQuery(sql,null);
        if(c.moveToFirst()){
            do{
                String linea= c.getInt(0) +" "+ c.getString(1)+" "+c.getString(2);
                datos.add(linea);
            }while(c.moveToNext());
        }
        db.close();
        return datos;
    }
}