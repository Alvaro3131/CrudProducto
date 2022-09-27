package com.example.crudproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText nombre,stock,decimal;
private Button guardar, mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.editTextNombre);
        stock=findViewById(R.id.editTextNumber);
        decimal=findViewById(R.id.editTextDecimal);
        guardar=findViewById(R.id.btnguardar);
        mostrar=findViewById(R.id.btnmostrar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(nombre.getText().toString(),Integer.parseInt(stock.getText().toString()),Double.parseDouble(decimal.getText().toString()));
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Listado.class));
            }
        });
    }
    private void guardar(String nombre, int stock, double precio){
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db=helper.getWritableDatabase();
        try {
            ContentValues c= new ContentValues();
            c.put("Nombre",nombre);
            c.put("Stock",stock);
            c.put("Precio",precio);
            db.insert("PRODUCTOS",null,c);
            db.close();
            Toast.makeText(this,"Registro insertado",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"Registro no insertado",Toast.LENGTH_SHORT).show();
        }
    }
}