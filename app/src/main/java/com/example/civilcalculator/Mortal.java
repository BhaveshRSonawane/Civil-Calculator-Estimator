package com.example.civilcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Mortal extends AppCompatActivity {
    float unitForVolume, unitForCement,unitForSand,unitForWeight;
    Spinner volumeSpinnerMortar,cementSpinnerMortar,sandSpinnerMortar;

    public void calculateMortar(View view){

        EditText editVolume = (EditText) findViewById(R.id.editVolumemortal);
        EditText editCementRatio = (EditText) findViewById(R.id.cementRatiomortal);
        EditText editSandRatio = (EditText) findViewById(R.id.sandRatiomortal);
        if(editCementRatio.getText().toString().isEmpty()
                ||editSandRatio.getText().toString().isEmpty()|| editVolume.getText().toString().isEmpty()){
            Toast.makeText(this, "Plz Enter the values", Toast.LENGTH_SHORT).show();
        }else {

            Double givenVolume = Double.parseDouble(editVolume.getText().toString());
            givenVolume=givenVolume*unitForVolume;
            Double cementRatio = Double.parseDouble(editCementRatio.getText().toString());
            Double sandRatio = Double.parseDouble(editSandRatio.getText().toString());
            Double cement,sand,weight,sumOfRatio,sumOfAllElement;

            sumOfAllElement = (givenVolume / 5) * 7;
            sumOfRatio = cementRatio + sandRatio ;
            cement = (sumOfAllElement) * (cementRatio / sumOfRatio);
            sand = (sumOfAllElement) * (sandRatio / sumOfRatio);
            weight = cement * 1440;
            cement =cement*unitForCement;
            sand=sand*unitForSand;

            cement=Math.round(cement * 100.0) / 100.0;
            weight=Math.round(weight * 100.0) / 100.0;
            sand=Math.round(sand * 100.0) / 100.0;

            TextView textCementMortal = findViewById(R.id.finalCementmortal);
            String cementMortal = String.valueOf(cement);
            textCementMortal.setText(cementMortal);

            TextView textSandMortal = findViewById(R.id.finalSandmortal);
            String sanDMortal = String.valueOf(sand);
            textSandMortal.setText(sanDMortal);

            TextView textWeightMortal = findViewById(R.id.cementByWeight);
            String weighTMortal = String.valueOf(weight);
            textWeightMortal.setText(weighTMortal);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortal);

        volumeSpinnerMortar =findViewById(R.id.volumeSpinnerMortar);
        cementSpinnerMortar=findViewById(R.id.cementSpinnerMortar);
        sandSpinnerMortar=findViewById(R.id.sandSpinnerMortar);

        ArrayList<String> volumeSpinnerMortarList= new ArrayList<>();
        ArrayList<String> cementSpinnerMortarList= new ArrayList<>();
        ArrayList<String> sandSpinnerMortarList= new ArrayList<>();

        volumeSpinnerMortarList.add("cu.Meter");
        volumeSpinnerMortarList.add("cu.mm");
        volumeSpinnerMortarList.add("cu.foot");
        volumeSpinnerMortarList.add("cu.cm");
        volumeSpinnerMortarList.add("cu.inch");

        cementSpinnerMortarList.add("cu.Meter");
        cementSpinnerMortarList.add("cu.mm");
        cementSpinnerMortarList.add("cu.foot");
        cementSpinnerMortarList.add("cu.cm");
        cementSpinnerMortarList.add("cu.inch");

        sandSpinnerMortarList.add("cu.Meter");
        sandSpinnerMortarList.add("cu.mm");
        sandSpinnerMortarList.add("cu.foot");
        sandSpinnerMortarList.add("cu.cm");
        sandSpinnerMortarList.add("cu.inch");


        volumeSpinnerMortar.setAdapter(new ArrayAdapter<>(Mortal.this,android.R.layout.simple_spinner_dropdown_item,volumeSpinnerMortarList));
        volumeSpinnerMortar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForVolume =1;
                }
                else if(position==1){
                    unitForVolume =(float )1/(1000*1000*1000);

                }
                else if(position==2){
                    unitForVolume =(float) 27/1000;

                }
                else if(position==3){
                    unitForVolume =(float)1/(100*100*100);

                }
                else if(position==4){
                    unitForVolume =(float)1/64000;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cementSpinnerMortar.setAdapter(new ArrayAdapter<>(Mortal.this,android.R.layout.simple_spinner_dropdown_item,cementSpinnerMortarList));
        cementSpinnerMortar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForCement =1;
                }
                else if(position==1){
                    unitForCement =(float )1000*1000*1000;

                }
                else if(position==2){
                    unitForCement =(float) 1000/27;

                }
                else if(position==3){
                    unitForCement =(float)100*100*100;

                }
                else if(position==4){
                    unitForCement =(float)64000;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sandSpinnerMortar.setAdapter(new ArrayAdapter<>(Mortal.this,android.R.layout.simple_spinner_dropdown_item,sandSpinnerMortarList));
        sandSpinnerMortar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForSand =1;
                }
                else if(position==1){
                    unitForSand =(float )1000*1000*1000;

                }
                else if(position==2){
                    unitForSand =(float) 1000/27;

                }
                else if(position==3){
                    unitForSand =(float)100*100*100;

                }
                else if(position==4){
                    unitForSand =(float)64000;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}