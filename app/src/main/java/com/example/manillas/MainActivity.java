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
    private TextView resultado;
    private Spinner comboMaterial;
    private Spinner comboDije;
    private Spinner comboMaterialDije;
    private String[] tipo_material;
    private String[] tipo_dije;
    private String[] material_dije;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cantidad = findViewById(R.id.cantidad);
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

    }

    public void calcular (View v){
        double cantidad_input;
        cantidad_input = Double.parseDouble(cantidad.getText().toString());
        //Log.d("tag" , String.valueOf(cantidad_input));
        int op;
        int op2;
        int op3;
        op = comboMaterial.getSelectedItemPosition();
        op2 = comboDije.getSelectedItemPosition();
        op3 = comboMaterialDije.getSelectedItemPosition();
        if(cantidad_input > 0){

        }
    }



}