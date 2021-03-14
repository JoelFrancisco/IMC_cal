package com.example.imc_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button switchToSecondActivity;
    EditText weighInput;
    EditText heightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToSecondActivity = findViewById(R.id.send_button);
        switchToSecondActivity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View View) {
                float imc = calculatingImc();
                String classification = classifying(imc);
                switchActivities(imc, classification);
            }
        });
    }

    private void switchActivities(float imc, String classification) {
        Intent switchActivityIntent = new Intent(this, MainActivity2.class);
        switchActivityIntent.putExtra("IMC", imc);
        switchActivityIntent.putExtra("CLASSIFICATION", classification);
        startActivity(switchActivityIntent);
    }

    private float calculatingImc() {
        weighInput = findViewById(R.id.weight_input);
        heightInput = findViewById(R.id.height_input);

        float weight = Float.parseFloat(weighInput.getText().toString());
        float height = Float.parseFloat(heightInput.getText().toString());

        float imc = weight / height;

        return imc;
    }

    private String classifying(float imc) {
        String classification;

        if (imc < 16) {
           classification = "Magreza grave";
        }
        else if ((imc > 16) && (imc < 17)) {
            classification = "Magreza moderada";
        }
        else if ((imc > 17) && (imc < 18.5)) {
            classification = "Magreza leve";
        }
        else if ((imc > 18.5) && (imc < 25)) {
            classification = "Saudável";
        }
        else if ((imc > 25) && (imc < 30)) {
            classification = "Sobrepeso";
        }
        else if ((imc > 30) && (imc < 35)) {
            classification = "Obesidade grau I";
        }
        else if ((imc > 35) && (imc < 40)) {
            classification = "Obesidade grau II";
        }
        else {
            classification = "Obesidade grau III";
        }

        return classification;
    }

}

