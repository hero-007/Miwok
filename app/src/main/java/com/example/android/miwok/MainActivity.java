package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewFamily = (TextView) findViewById(R.id.family_Id);
        textViewFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(i);
            }
        });
        TextView textViewNumbers = (TextView) findViewById(R.id.numbers_Id);
        TextView textViewColors = (TextView) findViewById(R.id.colors_Id);
        TextView textViewPhrases = (TextView) findViewById(R.id.phrases_Id);
        textViewNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(i);
            }
        });
        textViewColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(i);
            }
        });
        textViewPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(i);
            }
        });

    }

}
