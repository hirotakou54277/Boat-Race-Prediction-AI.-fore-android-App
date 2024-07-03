package com.example.boatraceprediction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.grid_layout);

        // 1から24までのボタンを動的に生成
        for (int i = 1; i <= 24; i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(i));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, RaceActivity.class);
                    intent.putExtra("venue_id", Integer.parseInt(button.getText().toString()));
                    startActivity(intent);
                }
            });
            gridLayout.addView(button);
        }
    }
}
