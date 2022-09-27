package com.example.crudproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar extends AppCompatActivity {
    private EditText nombres,stocks,decimales;
    private Button modificar, eliminar;
    int id;
    String nombre;
    int stock;
    String precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        Bundle b=getIntent().getExtras();
        if(b!=null){
                id=b.getInt("Id");
                nombre=b.getString("Nombre");
                stock=b.getInt("Stock");
                precio=b.getString("Precio");
        }
        nombres=findViewById(R.id.editTextNombres);
        stocks=findViewById(R.id.editTextNumbers);
        decimales=findViewById(R.id.editTextDecimales);
        modificar=findViewById(R.id.btnmodificar);
        eliminar=findViewById(R.id.btneliminar);

        nombres.setText(nombre);
        stocks.setText(String.valueOf(stock) );
        decimales.setText(precio);
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                modificardatos(id,nombres.getText().toString(),Integer.parseInt(stocks.getText().toString()),Double.parseDouble(decimales.getText().toString()));
                onBackPressed();
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminardatos(id);
                onBackPressed();
            }
        });

    }
    private void modificardatos(int id, String nombre,int stock, double precio){
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db=helper.getWritableDatabase();
        String sql= "update PRODUCTOS set Nombre='"+nombre+"',Stock='"+stock+"',Precio='"+precio+"' where ID="+id;
        db.execSQL(sql);
        db.close();

    }
    private void eliminardatos(int id){
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db=helper.getWritableDatabase();
        String sql= "delete from PRODUCTOS where ID="+id;
        db.execSQL(sql);
        db.close();

    }
}