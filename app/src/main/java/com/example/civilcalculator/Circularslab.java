package com.example.civilcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Circularslab extends AppCompatActivity {
    float unitForOuterRadius,unitForInnerRadius,unitForHeight,unitForVolume;
    Spinner outerUnits,innerUnits,heightUnits,volumeUnits;

    public void circularSlabCalculator(View view){
        EditText outerRadiusCircularSalb = (EditText) findViewById(R.id.outerRadiusCircularSalb);
        EditText innerRadiusCircularSalb = (EditText) findViewById(R.id.innerRadiusCircularSalb);
        EditText heightCircularSalb = (EditText) findViewById(R.id.heightCircularSalb);
        if(outerRadiusCircularSalb.getText().toString().isEmpty()|| innerRadiusCircularSalb.getText().toString().isEmpty()
                || heightCircularSalb.getText().toString().isEmpty()){
            Toast.makeText(this, "Plz Enter the values", Toast.LENGTH_SHORT).show();
        }else {

            double givenouterRadiusCircularSalb = Double.parseDouble(outerRadiusCircularSalb.getText().toString());
            givenouterRadiusCircularSalb=givenouterRadiusCircularSalb*unitForOuterRadius;
            double giveninnerRadiusCircularSalb = Double.parseDouble(innerRadiusCircularSalb.getText().toString());
            giveninnerRadiusCircularSalb=giveninnerRadiusCircularSalb*unitForInnerRadius;
            double givenheightCircularSalb = Double.parseDouble(heightCircularSalb.getText().toString());
            givenheightCircularSalb=givenheightCircularSalb* unitForHeight;



            double volumeCircularSlab;
            volumeCircularSlab=(givenheightCircularSalb*Math.PI*(Math.pow(givenouterRadiusCircularSalb, 2)-Math.pow(giveninnerRadiusCircularSalb, 2)))*unitForVolume;
            volumeCircularSlab=Math.round(volumeCircularSlab * 100.0) / 100.0;


            TextView textvolumeCircularSalb = findViewById(R.id.volumeCircularSalb);
            String textVolumeCircularSalb = String.valueOf(volumeCircularSlab);
            textvolumeCircularSalb.setText(textVolumeCircularSalb);


        }}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circularslab);

        outerUnits=findViewById(R.id.outerUnit);
        innerUnits=findViewById(R.id.innerUnits);
        heightUnits=findViewById(R.id.heightUnits);
        volumeUnits=findViewById(R.id.volumeUnits);

        ArrayList<String> outerList= new ArrayList<>();
        ArrayList<String> innerList= new ArrayList<>();
        ArrayList<String> heightList= new ArrayList<>();
        ArrayList<String> volumeList= new ArrayList<>();

        outerList.add("Meter");
        outerList.add("mm");
        outerList.add("foot");
        outerList.add("cm");
        outerList.add("inch");

        innerList.add("Meter");
        innerList.add("mm");
        innerList.add("foot");
        innerList.add("cm");
        innerList.add("inch");

        heightList.add("Meter");
        heightList.add("mm");
        heightList.add("foot");
        heightList.add("cm");
        heightList.add("inch");

        volumeList.add("cu.Meter");
        volumeList.add("cu.mm");
        volumeList.add("cu.foot");
        volumeList.add("cu.cm");
        volumeList.add("cu.inch");


        outerUnits.setAdapter(new ArrayAdapter<>(Circularslab.this,android.R.layout.simple_spinner_dropdown_item,outerList));
        outerUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForOuterRadius=1;
                }
                else if(position==1){
                    unitForOuterRadius=(float )1/1000;

                }
                else if(position==2){
                    unitForOuterRadius=(float) 3/10;

                }
                else if(position==3){
                    unitForOuterRadius=(float)1/100;

                }
                else if(position==4){
                    unitForOuterRadius=(float)1/40;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        innerUnits.setAdapter(new ArrayAdapter<>(Circularslab.this,android.R.layout.simple_spinner_dropdown_item,innerList));
        innerUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    unitForInnerRadius=1;
                }
                else if(position==1){
                    unitForInnerRadius=(float )1/1000;

                }
                else if(position==2){
                    unitForInnerRadius=(float) 3/10;

                }
                else if(position==3){
                    unitForInnerRadius=(float)1/100;

                }
                else if(position==4){
                    unitForInnerRadius=(float)1/40;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        heightUnits.setAdapter(new ArrayAdapter<>(Circularslab.this,android.R.layout.simple_spinner_dropdown_item,heightList));
        heightUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForHeight=1;
                }
                else if(position==1){
                    unitForHeight=(float )1/1000;

                }
                else if(position==2){
                    unitForHeight=(float) 3/10;

                }
                else if(position==3){
                    unitForHeight=(float)1/100;

                }
                else if(position==4){
                    unitForHeight=(float)1/40;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        volumeUnits.setAdapter(new ArrayAdapter<>(Circularslab.this,android.R.layout.simple_spinner_dropdown_item,volumeList));
        volumeUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForVolume=1;
                }
                else if(position==1){
                    unitForVolume=(float )1000*1000*1000;

                }
                else if(position==2){
                    unitForVolume=(float) 1000/27;

                }
                else if(position==3){
                    unitForVolume=(float)100*100*100;

                }
                else if(position==4){
                    unitForVolume=(float)64000;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}