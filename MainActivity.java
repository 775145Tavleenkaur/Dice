package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random random=new Random();
    ImageView dice1,dice2;
    Button btn_high,btn_low;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        btn_high = findViewById(R.id.btn_higher);
        btn_low = findViewById(R.id.btn_lower);
        result = findViewById(R.id.textresult);
        btn_high.setOnClickListener(view -> {

            int value1 = GenerateRandom();
            int value2 = GenerateRandom();

            int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.myapplication");
            int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.myapplication");
            dice1.setImageResource(res1);
            dice2.setImageResource(res2);
            if (value1 > value2) {
                result.setText("You won");
                result.setTextColor(getResources().getColor(R.color.win));
            } else if (value1 < value2) {
                result.setText("Computer won");
                result.setTextColor(getResources().getColor(R.color.loss));
            } else {
                result.setText("Its Tie");
                result.setTextColor(getResources().getColor(R.color.tie));
            }

        });

        btn_low.setOnClickListener(view -> {
            int value1 = GenerateRandom();
            int value2 = GenerateRandom();

            int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.myapplication");
            int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.myapplication");
            dice1.setImageResource(res1);
            dice2.setImageResource(res2);
            if (value1 < value2) {
                result.setText("You won");
                result.setTextColor(getResources().getColor(R.color.win));
            } else if (value1 > value2) {
                result.setText("Computer won");
                result.setTextColor(getResources().getColor(R.color.loss));
            } else {
                result.setText("Its Tie");
                result.setTextColor(getResources().getColor(R.color.tie));
            }

        });
    }

    public static int GenerateRandom(){
        return random.nextInt(6)+1;
    }

}