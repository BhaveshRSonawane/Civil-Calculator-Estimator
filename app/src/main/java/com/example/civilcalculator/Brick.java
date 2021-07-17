
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

public class Brick extends AppCompatActivity {
    float unitForLengthofWall,unitForheightOfWall,unitForThicknessofWall,unitForLengthofBrick,unitForWidthOfBrick,unitForHeightOfBrick,unitForCement,unitForSand;
    Spinner lengthSpinnerWallBrick,heightSpinnerWallBrick,thicknessSpinnerWallBrick,lengthSpinnerBrick,widthSpinnerBrick,heightSpinnerBrick,cementSpinnerBrick,sandSpinnerBrick;

    public void brickCalculator(View view){
        EditText lengthOfWall = (EditText) findViewById(R.id.lengthOfWall);
        EditText heightOfWall = (EditText) findViewById(R.id.heightOfWall);
        EditText lengthOfBrick = (EditText) findViewById(R.id.lengthOfBrick);
        EditText thicknessOfWall = (EditText) findViewById(R.id.thicknessOfWall);
        EditText widthOfBrick = (EditText) findViewById(R.id.widthOfBrick);
        EditText heightOfBrick = (EditText) findViewById(R.id.heightOfBrick);
        EditText cementRatioBrick = (EditText) findViewById(R.id.cementRatioBrick);
        EditText sandRatioBrick = (EditText) findViewById(R.id.sandRatioBrick);
        if(lengthOfWall.getText().toString().isEmpty() ||heightOfWall.getText().toString().isEmpty()
                || lengthOfBrick.getText().toString().isEmpty() ||thicknessOfWall.getText().toString().isEmpty()
                ||widthOfBrick.getText().toString().isEmpty()|| heightOfBrick.getText().toString().isEmpty()
                ||cementRatioBrick.getText().toString().isEmpty()|| sandRatioBrick.getText().toString().isEmpty()){
            Toast.makeText(this, "Plz Enter the values", Toast.LENGTH_SHORT).show();
        }else {
            double givenLengthOfWall = Double.parseDouble(lengthOfWall.getText().toString());
            givenLengthOfWall=givenLengthOfWall*unitForLengthofWall;

            double givenheightOfWall = Double.parseDouble(heightOfWall.getText().toString());
            givenheightOfWall=givenheightOfWall*unitForheightOfWall;
            double giventhicknessOfWall = Double.parseDouble(thicknessOfWall.getText().toString());
            givenheightOfWall=givenheightOfWall*unitForThicknessofWall;
            double givenlengthOfBrick = Double.parseDouble(lengthOfBrick.getText().toString());
            givenlengthOfBrick=givenlengthOfBrick*unitForLengthofBrick;
            double givenwidthOfBrick = Double.parseDouble(widthOfBrick.getText().toString());
            givenwidthOfBrick=givenwidthOfBrick*unitForWidthOfBrick;
            double givenheightOfBrick = Double.parseDouble(heightOfBrick.getText().toString());
            givenheightOfBrick=givenheightOfBrick*unitForHeightOfBrick;
            double givencementRatioBrick = Double.parseDouble(cementRatioBrick.getText().toString());
            double givensandRatioBrick = Double.parseDouble(sandRatioBrick.getText().toString());

            double volumeOfWall,volumeOfBrickWithMortar,actualvolumeOfMortor,quantityOfMortar,cementVolumeBrick,sandRequiredBrick,cementWeightBrick,sumOfRatioBrick;
            int noOfBricks;
            double unitChangecementVolumeBrick,unitChangesandRequiredBrick;

            volumeOfWall=givenLengthOfWall*givenheightOfWall*giventhicknessOfWall;
            volumeOfBrickWithMortar=(float)((givenlengthOfBrick/1000)+0.01)*((givenwidthOfBrick/1000)+0.01)*((givenheightOfBrick/1000)+0.01);
            noOfBricks= (int) Math.round((volumeOfWall/volumeOfBrickWithMortar));


            actualvolumeOfMortor=(float)noOfBricks*(givenlengthOfBrick/1000)*(givenwidthOfBrick/1000)*(givenheightOfBrick/1000);
            quantityOfMortar=(float)volumeOfWall-actualvolumeOfMortor;
            quantityOfMortar=quantityOfMortar+(quantityOfMortar*0.15);
            quantityOfMortar=quantityOfMortar+(quantityOfMortar*0.25);
            sumOfRatioBrick=givencementRatioBrick+givensandRatioBrick;
            cementVolumeBrick=(float)(givencementRatioBrick/sumOfRatioBrick)*quantityOfMortar;
            unitChangecementVolumeBrick=cementVolumeBrick*unitForCement;
            sandRequiredBrick=(float)(givensandRatioBrick/sumOfRatioBrick)*quantityOfMortar;
            unitChangesandRequiredBrick=sandRequiredBrick*unitForSand;
            cementWeightBrick=(float)cementVolumeBrick*1440;


            unitChangecementVolumeBrick=Math.round(unitChangecementVolumeBrick * 100.0) / 100.0;
            unitChangesandRequiredBrick=Math.round(unitChangesandRequiredBrick * 100.0) / 100.0;
            cementWeightBrick=Math.round(cementWeightBrick * 100.0) / 100.0;


            TextView textnoOfBricks = findViewById(R.id.noOfBrick);
            String noOfBricksBricks = String.valueOf(noOfBricks);
            textnoOfBricks.setText(noOfBricksBricks);

            TextView textcementVolumeBrick = findViewById(R.id.cementbyVolumeBrick);
            String textcementVolumeBrickBricks = String.valueOf(unitChangecementVolumeBrick);
            textcementVolumeBrick.setText(textcementVolumeBrickBricks);

            TextView textsandRequiredBrick = findViewById(R.id.sandRequired);
            String sandRequiredBrickBricks = String.valueOf(unitChangesandRequiredBrick);
            textsandRequiredBrick.setText(sandRequiredBrickBricks);

            TextView textcementWeightBrick = findViewById(R.id.cementByWeightBrick);
            String cementWeightBrickBricks = String.valueOf(cementWeightBrick);
            textcementWeightBrick.setText(cementWeightBrickBricks);
        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brick);

        lengthSpinnerWallBrick=findViewById(R.id.lengthSpinnerWallBrick);
        heightSpinnerWallBrick=findViewById(R.id.heightSpinnerWallBrick);
        thicknessSpinnerWallBrick=findViewById(R.id.thicknessSpinnerWallBrick);
        lengthSpinnerBrick=findViewById(R.id.lengthSpinnerBrick);
        widthSpinnerBrick=findViewById(R.id.widthSpinnerBrick);
        heightSpinnerBrick=findViewById(R.id.heightSpinnerBrick);
        cementSpinnerBrick=findViewById(R.id.cementSpinnerBrick);
        sandSpinnerBrick=findViewById(R.id.sandSpinnerBrick);

        ArrayList<String> lengthSpinnerWallBrickList= new ArrayList<>();
        ArrayList<String> heightSpinnerWallBrickList= new ArrayList<>();
        ArrayList<String> thicknessSpinnerWallBrickList= new ArrayList<>();
        ArrayList<String> lengthSpinnerBrickList= new ArrayList<>();

        ArrayList<String> widthSpinnerBrickList= new ArrayList<>();
        ArrayList<String> heightSpinnerBrickList= new ArrayList<>();
        ArrayList<String> cementSpinnerBrickList= new ArrayList<>();
        ArrayList<String> sandSpinnerBrickList= new ArrayList<>();

        lengthSpinnerWallBrickList.add("Meter");
        lengthSpinnerWallBrickList.add("mm");
        lengthSpinnerWallBrickList.add("foot");
        lengthSpinnerWallBrickList.add("cm");
        lengthSpinnerWallBrickList.add("inch");

        heightSpinnerWallBrickList.add("Meter");
        heightSpinnerWallBrickList.add("mm");
        heightSpinnerWallBrickList.add("foot");
        heightSpinnerWallBrickList.add("cm");
        heightSpinnerWallBrickList.add("inch");

        thicknessSpinnerWallBrickList.add("Meter");
        thicknessSpinnerWallBrickList.add("mm");
        thicknessSpinnerWallBrickList.add("foot");
        thicknessSpinnerWallBrickList.add("cm");
        thicknessSpinnerWallBrickList.add("inch");


        lengthSpinnerBrickList.add("mm");
        lengthSpinnerBrickList.add("cm");
        lengthSpinnerBrickList.add("inch");

        widthSpinnerBrickList.add("mm");
        widthSpinnerBrickList.add("cm");
        widthSpinnerBrickList.add("inch");

        heightSpinnerBrickList.add("mm");
        heightSpinnerBrickList.add("cm");
        heightSpinnerBrickList.add("inch");

        cementSpinnerBrickList.add("cu.Meter");
        cementSpinnerBrickList.add("cu.mm");
        cementSpinnerBrickList.add("cu.foot");
        cementSpinnerBrickList.add("cu.cm");
        cementSpinnerBrickList.add("cu.inch");

        sandSpinnerBrickList.add("cu.Meter");
        sandSpinnerBrickList.add("cu.mm");
        sandSpinnerBrickList.add("cu.foot");
        sandSpinnerBrickList.add("cu.cm");
        sandSpinnerBrickList.add("cu.inch");

        lengthSpinnerWallBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,lengthSpinnerWallBrickList));
        lengthSpinnerWallBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForheightOfWall=1;
                }
                else if(position==1){
                    unitForheightOfWall=(float )1/1000;

                }
                else if(position==2){
                    unitForheightOfWall=(float) 3/10;

                }
                else if(position==3){
                    unitForheightOfWall=(float)1/100;

                }
                else if(position==4){
                    unitForheightOfWall= (float) (1/39.3701);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        heightSpinnerWallBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,heightSpinnerWallBrickList));
        heightSpinnerWallBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForLengthofWall=1;
                }
                else if(position==1){
                    unitForLengthofWall=(float )1/1000;

                }
                else if(position==2){
                    unitForLengthofWall=(float) 3/10;

                }
                else if(position==3){
                    unitForLengthofWall=(float)1/100;

                }
                else if(position==4){
                    unitForLengthofWall= (float) (1/39.3701);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        thicknessSpinnerWallBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,thicknessSpinnerWallBrickList));
        thicknessSpinnerWallBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForThicknessofWall=1;
                }
                else if(position==1){
                    unitForThicknessofWall=(float )1/1000;

                }
                else if(position==2){
                    unitForThicknessofWall=(float) 3/10;

                }
                else if(position==3){
                    unitForThicknessofWall=(float)1/100;

                }
                else if(position==4){
                    unitForThicknessofWall= (float) (1/39.3701);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lengthSpinnerBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,lengthSpinnerBrickList));
        lengthSpinnerBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForLengthofBrick=1;
                }
                else if(position==1){
                    unitForLengthofBrick=(float )10;

                }
                else if(position==2){
                    unitForLengthofBrick= (float) 25.4;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        widthSpinnerBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,widthSpinnerBrickList));
        widthSpinnerBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForWidthOfBrick=1;
                }
                else if(position==1){
                    unitForWidthOfBrick=(float )10;

                }
                else if(position==2){
                    unitForWidthOfBrick= (float) 25.4;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        heightSpinnerBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,heightSpinnerBrickList));
        heightSpinnerBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    unitForHeightOfBrick=1;
                }
                else if(position==1){
                    unitForHeightOfBrick=(float )10;

                }
                else if(position==2){
                    unitForHeightOfBrick= (float) 25.4;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cementSpinnerBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,cementSpinnerBrickList));
        cementSpinnerBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    unitForCement=(float)61024;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sandSpinnerBrick.setAdapter(new ArrayAdapter<>(Brick.this,android.R.layout.simple_spinner_dropdown_item,sandSpinnerBrickList));
        sandSpinnerBrick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    unitForSand=(float)61024;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}

