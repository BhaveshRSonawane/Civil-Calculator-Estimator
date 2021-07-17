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

public class Slab extends AppCompatActivity {
    float unitForlength,unitForWidth,unitForHeight,unitForVolume;
    Spinner lengthSpinnerSlab,widthSpinnerSlab,heightSpinnerSlab,volumeSpinnerSlab;

    public void slabCalculator(View view){
        EditText lengthSlab = (EditText) findViewById(R.id.lengthSlab);
        EditText widthSlab = (EditText) findViewById(R.id.widthSlab);
        EditText heightSlab = (EditText) findViewById(R.id.heightSlab);
        if(lengthSlab.getText().toString().isEmpty()
                ||heightSlab.getText().toString().isEmpty()|| widthSlab.getText().toString().isEmpty()){
            Toast.makeText(this, "Plz Enter the values", Toast.LENGTH_SHORT).show();
        }else {

            double givenlengthSlab = Double.parseDouble(lengthSlab.getText().toString());
            givenlengthSlab=givenlengthSlab*unitForlength;
            double givenwidthSlab = Double.parseDouble(widthSlab.getText().toString());
            givenwidthSlab=givenwidthSlab*unitForWidth;
            double givenheightSlab = Double.parseDouble(heightSlab.getText().toString());
            givenheightSlab=givenheightSlab*unitForHeight;

            double volumeSlab;
            volumeSlab=(givenheightSlab*givenlengthSlab*givenwidthSlab)*unitForVolume;

            volumeSlab=Math.round(volumeSlab * 100.0) / 100.0;



            TextView textvolumeSlab = findViewById(R.id.volumeSlab);
            String textVolumeSlab = String.valueOf(volumeSlab);
            textvolumeSlab.setText(textVolumeSlab);


        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slab);

        lengthSpinnerSlab=findViewById(R.id.lengthSpinnerSlab);
        widthSpinnerSlab=findViewById(R.id.widthSpinnerSlab);
        heightSpinnerSlab=findViewById(R.id.heightSpinnerSlab);
        volumeSpinnerSlab=findViewById(R.id.volumeSpinnerSlab);

        ArrayList<String> lengthSpinnerSlabList= new ArrayList<>();
        ArrayList<String> widthSpinnerSlabList= new ArrayList<>();
        ArrayList<String> heightSpinnerSlabList= new ArrayList<>();
        ArrayList<String> volumeSpinnerSlabList= new ArrayList<>();

        lengthSpinnerSlabList.add("Meter");
        lengthSpinnerSlabList.add("mm");
        lengthSpinnerSlabList.add("foot");
        lengthSpinnerSlabList.add("cm");
        lengthSpinnerSlabList.add("inch");

        widthSpinnerSlabList.add("Meter");
        widthSpinnerSlabList.add("mm");
        widthSpinnerSlabList.add("foot");
        widthSpinnerSlabList.add("cm");
        widthSpinnerSlabList.add("inch");

        heightSpinnerSlabList.add("Meter");
        heightSpinnerSlabList.add("mm");
        heightSpinnerSlabList.add("foot");
        heightSpinnerSlabList.add("cm");
        heightSpinnerSlabList.add("inch");

        volumeSpinnerSlabList.add("cu.Meter");
        volumeSpinnerSlabList.add("cu.mm");
        volumeSpinnerSlabList.add("cu.foot");
        volumeSpinnerSlabList.add("cu.cm");
        volumeSpinnerSlabList.add("cu.inch");



        lengthSpinnerSlab.setAdapter(new ArrayAdapter<>(Slab.this,android.R.layout.simple_spinner_dropdown_item,lengthSpinnerSlabList));
        lengthSpinnerSlab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForlength=1;
                }
                else if(position==1){
                    unitForlength=(float )1/1000;

                }
                else if(position==2){
                    unitForlength=(float) 3/10;

                }
                else if(position==3){
                    unitForlength=(float)1/100;

                }
                else if(position==4){
                    unitForlength=(float)1/40;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        widthSpinnerSlab.setAdapter(new ArrayAdapter<>(Slab.this,android.R.layout.simple_spinner_dropdown_item,widthSpinnerSlabList));
        widthSpinnerSlab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    unitForWidth=1;
                }
                else if(position==1){
                    unitForWidth=(float )1/1000;

                }
                else if(position==2){
                    unitForWidth=(float) 3/10;

                }
                else if(position==3){
                    unitForWidth=(float)1/100;

                }
                else if(position==4){
                    unitForWidth=(float)1/40;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        heightSpinnerSlab.setAdapter(new ArrayAdapter<>(Slab.this,android.R.layout.simple_spinner_dropdown_item,heightSpinnerSlabList));
        heightSpinnerSlab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        volumeSpinnerSlab.setAdapter(new ArrayAdapter<>(Slab.this,android.R.layout.simple_spinner_dropdown_item,volumeSpinnerSlabList));
        volumeSpinnerSlab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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