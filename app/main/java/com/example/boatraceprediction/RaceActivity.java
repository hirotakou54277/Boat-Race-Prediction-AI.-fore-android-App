package com.example.boatraceprediction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.GridLayout;

public class RaceActivity extends AppCompatActivity {
    private int venueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        venueId = getIntent().getIntExtra("venue_id", 0);
        GridLayout gridLayout = findViewById(R.id.grid_layout);

        // 1から12までのボタンを動的に生成
        for (int i = 1; i <= 12; i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(i));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RaceActivity.this, PredictionActivity.class);
                    intent.putExtra("venue_id", venueId);
                    intent.putExtra("race_id", Integer.parseInt(button.getText().toString()));
                    startActivity(intent);
                }
            });
            gridLayout.addView(button);
        }
    }
}
