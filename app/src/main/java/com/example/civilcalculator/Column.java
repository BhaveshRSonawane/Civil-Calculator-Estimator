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

public class Column extends AppCompatActivity {
    float unitradius,unitHeight,unitVolume;
    Spinner radiusSpinnerColumn,heightSpinnerColumn,volumeSpinnerColumn;

    public void columnCalculator(View view){
        EditText radiusColumn = (EditText) findViewById(R.id.radiusColumn);
        EditText heightColumn = (EditText) findViewById(R.id.heightColumn);
        if(radiusColumn.getText().toString().isEmpty()|| heightColumn.getText().toString().isEmpty()){
            Toast.makeText(this, "Plz Enter the values", Toast.LENGTH_SHORT).show();
        }else {


            double givenradiusColumn = Double.parseDouble(radiusColumn.getText().toString());
            givenradiusColumn=givenradiusColumn*unitradius;
            double givenheightColumn = Double.parseDouble(heightColumn.getText().toString());
            givenheightColumn=givenheightColumn*unitHeight;
            double volumeColumn;
            volumeColumn=givenradiusColumn*givenheightColumn*givenradiusColumn*Math.PI*unitVolume;
            volumeColumn=Math.round(volumeColumn * 100.0) / 100.0;


            TextView textvolumeColumn = findViewById(R.id.volumeColumn);
            String textVolumeColumn = String.valueOf(volumeColumn);
            textvolumeColumn .setText(textVolumeColumn);
        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column);

        radiusSpinnerColumn=findViewById(R.id.radiusSpinnerColumn);
        heightSpinnerColumn=findViewById(R.id.heightSpinnerColumn);
        volumeSpinnerColumn=findViewById(R.id.volumeSpinnerColumn);

        ArrayList<String> radiusSpinnerColumnList= new ArrayList<>();
        ArrayList<String> heightSpinnerColumnList= new ArrayList<>();
        ArrayList<String> volumeSpinnerColumnList= new ArrayList<>();

        radiusSpinnerColumnList.add("Meter");
        radiusSpinnerColumnList.add("mm");
        radiusSpinnerColumnList.add("foot");
        radiusSpinnerColumnList.add("cm");
        radiusSpinnerColumnList.add("inch");

        heightSpinnerColumnList.add("Meter");
        heightSpinnerColumnList.add("mm");
        heightSpinnerColumnList.add("foot");
        heightSpinnerColumnList.add("cm");
        heightSpinnerColumnList.add("inch");

        volumeSpinnerColumnList.add("cu.Meter");
        volumeSpinnerColumnList.add("cu.mm");
        volumeSpinnerColumnList.add("cu.foot");
        volumeSpinnerColumnList.add("cu.cm");
        volumeSpinnerColumnList.add("cu.inch");

        radiusSpinnerColumn.setAdapter(new ArrayAdapter<>(Column.this,android.R.layout.simple_spinner_dropdown_item,radiusSpinnerColumnList));
        radiusSpinnerColumn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitradius=1;
                }
                else if(position==1){
                    unitradius=(float )1/1000;

                }
                else if(position==2){
                    unitradius=(float) 3/10;

                }
                else if(position==3){
                    unitradius=(float)1/100;

                }
                else if(position==4){
                    unitradius=(float)1/40;

                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        heightSpinnerColumn.setAdapter(new ArrayAdapter<>(Column.this,android.R.layout.simple_spinner_dropdown_item,heightSpinnerColumnList));
        heightSpinnerColumn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    unitHeight=1;
                }
                else if(position==1){
                    unitHeight=(float )1/1000;

                }
                else if(position==2){
                    unitHeight=(float) 3/10;

                }
                else if(position==3){
                    unitHeight=(float)1/100;

                }
                else if(position==4){
                    unitHeight=(float)1/40;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        volumeSpinnerColumn.setAdapter(new ArrayAdapter<>(Column.this,android.R.layout.simple_spinner_dropdown_item,volumeSpinnerColumnList));
        volumeSpinnerColumn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitVolume=1;
                }
                else if(position==1){
                    unitVolume=(float )1000*1000*1000;

                }
                else if(position==2){
                    unitVolume=(float) 1000/27;

                }
                else if(position==3){
                    unitVolume=(float)100*100*100;

                }
                else if(position==4){
                    unitVolume=(float)64000;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}