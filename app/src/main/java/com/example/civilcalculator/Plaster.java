package com.example.civilcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Plaster extends AppCompatActivity {

    public void plasterCalculator(View view){
        EditText surfaceAreaPlaster = (EditText) findViewById(R.id.surfaceAreaPlaster);
        EditText thicknessPlaster = (EditText) findViewById(R.id.thicknessPlaster);

        EditText cementRatioPlaster = (EditText) findViewById(R.id.cementRatioPlaster);
        EditText sandRatioPlaster = (EditText) findViewById(R.id.sandRatioPlaster);
        if(surfaceAreaPlaster.getText().toString().isEmpty()||thicknessPlaster.getText().toString().isEmpty()
                ||cementRatioPlaster.getText().toString().isEmpty()|| sandRatioPlaster.getText().toString().isEmpty()){
            Toast.makeText(this, "Plz Enter the values", Toast.LENGTH_SHORT).show();
        }else {


            double givensurfaceAreaPlaster = Double.parseDouble(surfaceAreaPlaster.getText().toString());
            double giventhicknessPlaster = Double.parseDouble(thicknessPlaster.getText().toString());

            double givencementRatioPlaster = Double.parseDouble(cementRatioPlaster.getText().toString());
            double givensandRatioPlaster = Double.parseDouble(sandRatioPlaster.getText().toString());

            double sumOfRatio,cementVolumePlaster,sandRequiredPlaster,cementWeightPlaster;
            sumOfRatio=givencementRatioPlaster+givensandRatioPlaster;
            cementVolumePlaster=(givencementRatioPlaster/sumOfRatio)*0.0015*(givensurfaceAreaPlaster*giventhicknessPlaster);
            sandRequiredPlaster=(givensandRatioPlaster/sumOfRatio)*0.0015*(givensurfaceAreaPlaster*giventhicknessPlaster);
            cementWeightPlaster=cementVolumePlaster*1440;

            cementVolumePlaster=Math.round(cementVolumePlaster * 100.0) / 100.0;
            sandRequiredPlaster=Math.round(sandRequiredPlaster * 100.0) / 100.0;
            cementWeightPlaster=Math.round(cementWeightPlaster * 100.0) / 100.0;


            TextView textcementbyVolumePlaster = findViewById(R.id.cementbyVolumePlaster);
            String textcementVolumePlaster = String.valueOf(cementVolumePlaster);
            textcementbyVolumePlaster.setText(textcementVolumePlaster);

            TextView textsandRequiredPlaster = findViewById(R.id.sandRequiredPlaster);
            String textsandRequiredPlasterp = String.valueOf(sandRequiredPlaster);
            textsandRequiredPlaster.setText(textsandRequiredPlasterp);

            TextView textcementByWeightPlaster = findViewById(R.id.cementByWeightPlaster);
            String cementWeightPlasterr = String.valueOf(cementWeightPlaster);
            textcementByWeightPlaster.setText(cementWeightPlasterr);
        }}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plaster);
    }
}