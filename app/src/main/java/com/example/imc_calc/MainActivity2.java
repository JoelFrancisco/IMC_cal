package com.example.imc_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();

        float imc = extras.getFloat("IMC");
        String classification = extras.getString("CLASSIFICATION");

        TextView textImc = (TextView) findViewById(R.id.textImc);
        TextView textClassification = (TextView) findViewById(R.id.textClassification);

        textImc.setText(Float.toString(imc));
        textClassification.setText(classification);
    }
}