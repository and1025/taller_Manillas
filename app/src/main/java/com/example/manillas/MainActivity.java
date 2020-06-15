package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText cantidad;
    private TextView total;
    //private TextView resultado;
    private Spinner comboMaterial;
    private Spinner comboDije;
    private Spinner comboMaterialDije;
    private Spinner comboMoneda;
    private String[] tipo_material;
    private String[] tipo_dije;
    private String[] material_dije;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cantidad = findViewById(R.id.cantidad);
        total = findViewById(R.id.total);
        //resultado = findViewById(R.id.lblResultado);

        /*Combo para el material de la manilla*/
        comboMaterial = findViewById(R.id.comboMaterial);
        tipo_material = getResources().getStringArray(R.array.tipo_material);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, tipo_material);
        comboMaterial.setAdapter(adapter);

        /*Combo para el tipo de dije*/
        comboDije = findViewById(R.id.comboDije);
        tipo_dije = getResources().getStringArray(R.array.tipo_dije);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, tipo_dije);
        comboDije.setAdapter(adapter);

        /*Combo para el material del dije*/
        comboMaterialDije = findViewById(R.id.comboMaterialDije);
        material_dije = getResources().getStringArray(R.array.material_dije);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, material_dije);
        comboMaterialDije.setAdapter(adapter);

        /*Combo para el tipo de moneda*/
        comboMoneda = findViewById(R.id.comboTipoMoneda);
        String[] tipo_moneda = getResources().getStringArray(R.array.tipo_moneda);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, tipo_moneda);
        comboMoneda.setAdapter(adapter);
    }

    public void calcular (View v){
        double cantidad_input = 0;
        int dolar_price = 3200;
        int precio_unitario = 0;
        if(!cantidad.getText().toString().isEmpty()){
            cantidad_input = Double.parseDouble(cantidad.getText().toString());
        }

        //Log.d("tag" , String.valueOf(cantidad_input));
        int op;
        int op2;
        String tipo ;
        int op3;
        int op4;
        String error_cero, error_vacio;

        op = comboMaterial.getSelectedItemPosition();
        op2 = comboDije.getSelectedItemPosition();
        op3 = comboMaterialDije.getSelectedItemPosition();
        op4 = comboMoneda.getSelectedItemPosition();
        error_cero = getResources().getString(R.string.error_cero);
        error_vacio = getResources().getString(R.string.error_vacio);
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(error_vacio);
            cantidad.requestFocus();
            return;
        }
        if(cantidad_input > 0){
            if(op == 0){
                //cuero
                //Log.d("input1" , String.valueOf(op));
                if(op2 == 0){
                    //es martillo
                    if(op3 == 0 || op3 == 1){
                        precio_unitario = 100;
                    }else if(op3 == 2){
                        precio_unitario = 80;
                    }else{
                        precio_unitario = 70;
                    }
                }else{
                    if(op3 == 0 || op3 == 1){
                        precio_unitario = 120;
                    }else if(op3 == 2){
                        precio_unitario = 100;
                    }else{
                        precio_unitario = 90;
                    }
                }
            }else if(op == 1){
                //Log.d("input1" , String.valueOf(op));
                if(op2 == 0){
                    //es martillo
                    if(op3 == 0 || op3 == 1){
                        precio_unitario = 90;
                    }else if(op3 == 2){
                        precio_unitario = 70;
                    }else{
                        precio_unitario = 50;
                    }
                }else{
                    if(op3 == 0 || op3 == 1){
                        precio_unitario = 110;
                    }else if(op3 == 2){
                        precio_unitario = 90;
                    }else{
                        precio_unitario = 80;
                    }
                }
            }
        }
        else {
            cantidad.setError(error_cero);
            cantidad.requestFocus();
            return;
        }
        if(op4 == 0){
            total.setText("     Total: " + " " +precio_unitario * cantidad_input + " USD");
        }else{
            total.setText("     Total:"+ " " +precio_unitario * dolar_price * cantidad_input + " Pesos");
        }
        cantidad.setText("");
    }



}