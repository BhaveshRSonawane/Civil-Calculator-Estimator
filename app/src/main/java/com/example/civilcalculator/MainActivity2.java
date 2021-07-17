package com.example.civilcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button =(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvtivity2();
            }
        });
        button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvtivity3();
            }
        });

        button3 =(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvtivity4();
            }
        });

        button4 =(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvtivity5();
            }
        });

        button5 =(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvtivity6();
            }
        });

        button6 =(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvtivity7();
            }
        });

        button7 =(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvtivity8();
            }
        });
    }

    public void openAvtivity2(){
        // Intent to open another activity
        Intent intent=new Intent(this,Concrete.class);
        startActivity(intent);

    }
    public void openAvtivity3(){
        // Intent to open another activity
        Intent intent=new Intent(this,Mortal.class);
        startActivity(intent);

    }
    public void openAvtivity4(){
        // Intent to open another activity
        Intent intent=new Intent(this,Brick.class);
        startActivity(intent);

    }
    public void openAvtivity5(){
        // Intent to open another activity
        Intent intent=new Intent(this,Plaster.class);
        startActivity(intent);

    }
    public void openAvtivity6(){
        // Intent to open another activity
        Intent intent=new Intent(this,Slab.class);
        startActivity(intent);

    }
    public void openAvtivity7(){
        // Intent to open another activity
        Intent intent=new Intent(this,Column.class);
        startActivity(intent);

    }
    public void openAvtivity8(){
        // Intent to open another activity
        Intent intent=new Intent(this,Circularslab.class);
        startActivity(intent);

    }
}