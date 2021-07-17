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

public class Concrete extends AppCompatActivity {
        float unitForVolume,unitForCement,unitForSand,unitForCourse;
        Spinner volumeSpinnerConcrete,cementSpinnerConcrete,sandSpinnerConcrete,courseSpinnerConcrete;


    public void calculateConcrete(View view){


        EditText editVolume = (EditText) findViewById(R.id.editVolume);
        EditText editCementRatio = (EditText) findViewById(R.id.cementRatio);
        EditText editSandRatio = (EditText) findViewById(R.id.sandRatio);
        EditText editCourseAggRatio = (EditText) findViewById(R.id.coarseAggregateRatio);
        if(editCementRatio.getText().toString().isEmpty() || editCourseAggRatio.getText().toString().isEmpty()
                ||editSandRatio.getText().toString().isEmpty()|| editVolume.getText().toString().isEmpty()){
            Toast.makeText(this, "Plz Enter the values", Toast.LENGTH_SHORT).show();
        }else {

            Double givenVolume =Double.parseDouble(editVolume.getText().toString());
            givenVolume=givenVolume*unitForVolume;
            Double cementRatio =Double.parseDouble(editCementRatio.getText().toString());
            Double sandRatio = Double.parseDouble(editSandRatio.getText().toString());
            Double courseAggRatio = Double.parseDouble(editCourseAggRatio.getText().toString());
            Double cement,sand,courseagg,weight,sumOfRatio,sumOfAllElement;

            sumOfAllElement = (givenVolume / 2) * 3;
            sumOfRatio = cementRatio + sandRatio + courseAggRatio;
            cement = ((sumOfAllElement) * (cementRatio / sumOfRatio));
            sand = ((sumOfAllElement) * (sandRatio / sumOfRatio));
            courseagg = ((sumOfAllElement) * (courseAggRatio / sumOfRatio));
            weight = cement * 1440;
            cement =cement*unitForCement;
            sand=sand*unitForSand;
            courseagg=courseagg*unitForCourse;

            cement=Math.round(cement * 100.0) / 100.0;
            sand=Math.round(sand * 100.0) / 100.0;
            courseagg=Math.round(courseagg * 100.0) / 100.0;
            weight=Math.round(weight * 100.0) / 100.0;


            TextView textCement = findViewById(R.id.finalCement);
            String cemenT = String.valueOf(cement);
            textCement.setText(cemenT);

            TextView textSand = findViewById(R.id.finalSand);
            String sanD = String.valueOf(sand);
            textSand.setText(sanD);

            TextView textCourseAgg = findViewById(R.id.finalCoarseAggregate);
            String courseAgg = String.valueOf(courseagg);
            textCourseAgg.setText(courseAgg);

            TextView textWeight = findViewById(R.id.cementByWeight);
            String weighT = String.valueOf(weight);
            textWeight.setText(weighT);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concrete);

        volumeSpinnerConcrete=findViewById(R.id.volumeSpinnerConcrete);
        cementSpinnerConcrete=findViewById(R.id.cementSpinnerConcrete);
        sandSpinnerConcrete=findViewById(R.id.sandSpinnerConcrete);
        courseSpinnerConcrete=findViewById(R.id.courseSpinnerConcrete);

        ArrayList<String> volumeSpinnerConcreteList= new ArrayList<>();
        ArrayList<String> cementSpinnerConcreteList= new ArrayList<>();
        ArrayList<String> sandSpinnerConcreteList= new ArrayList<>();
        ArrayList<String> courseSpinnerConcreteList= new ArrayList<>();

        volumeSpinnerConcreteList.add("cu.Meter");
        volumeSpinnerConcreteList.add("cu.mm");
        volumeSpinnerConcreteList.add("cu.foot");
        volumeSpinnerConcreteList.add("cu.cm");
        volumeSpinnerConcreteList.add("cu.inch");

        cementSpinnerConcreteList.add("cu.Meter");
        cementSpinnerConcreteList.add("cu.mm");
        cementSpinnerConcreteList.add("cu.foot");
        cementSpinnerConcreteList.add("cu.cm");
        cementSpinnerConcreteList.add("cu.inch");

        sandSpinnerConcreteList.add("cu.Meter");
        sandSpinnerConcreteList.add("cu.mm");
        sandSpinnerConcreteList.add("cu.foot");
        sandSpinnerConcreteList.add("cu.cm");
        sandSpinnerConcreteList.add("cu.inch");

        courseSpinnerConcreteList.add("cu.Meter");
        courseSpinnerConcreteList.add("cu.mm");
        courseSpinnerConcreteList.add("cu.foot");
        courseSpinnerConcreteList.add("cu.cm");
        courseSpinnerConcreteList.add("cu.inch");

        volumeSpinnerConcrete.setAdapter(new ArrayAdapter<>(Concrete.this,android.R.layout.simple_spinner_dropdown_item,volumeSpinnerConcreteList));
        volumeSpinnerConcrete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    unitForVolume=1;
                }
                else if(position==1){
                    unitForVolume=(float )1/(1000*1000*1000);

                }
                else if(position==2){
                    unitForVolume=(float) 27/1000;

                }
                else if(position==3){
                    unitForVolume=(float)1/(100*100*100);

                }
                else if(position==4){
                    unitForVolume=(float)1/64000;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cementSpinnerConcrete.setAdapter(new ArrayAdapter<>(Concrete.this,android.R.layout.simple_spinner_dropdown_item,cementSpinnerConcreteList));
        cementSpinnerConcrete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    unitForCement=1;
                }
                else if(position==1){
                    unitForCement=(float )1000*1000*1000;

                }
                else if(position==2){
                    unitForCement=(float) 1000/27;

                }
                else if(position==3){
                    unitForCement=(float)100*100*100;

                }
                else if(position==4){
                    unitForCement=(float)64000;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sandSpinnerConcrete.setAdapter(new ArrayAdapter<>(Concrete.this,android.R.layout.simple_spinner_dropdown_item,sandSpinnerConcreteList));
        sandSpinnerConcrete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    unitForSand=1;
                }
                else if(position==1){
                    unitForSand=(float )1000*1000*1000;

                }
                else if(position==2){
                    unitForSand=(float) 1000/27;

                }
                else if(position==3){
                    unitForSand=(float)100*100*100;

                }
                else if(position==4){
                    unitForSand=(float)64000;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        courseSpinnerConcrete.setAdapter(new ArrayAdapter<>(Concrete.this,android.R.layout.simple_spinner_dropdown_item,courseSpinnerConcreteList));
        courseSpinnerConcrete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    unitForCourse=1;
                }
                else if(position==1){
                    unitForCourse=(float )1000*1000*1000;

                }
                else if(position==2){
                    unitForCourse=(float) 1000/27;

                }
                else if(position==3){
                    unitForCourse=(float)100*100*100;

                }
                else if(position==4){
                    unitForCourse=(float)64000;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}