package com.example.boatraceprediction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.GridLayout;

public class RaceActivity extends AppCompatActivity {
    private int venueId;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        venueId = getIntent().getIntExtra("venue_id", 0);
        gridLayout = findViewById(R.id.grid_layout);

        // 既にボタンが追加されている場合は追加しない
        if (gridLayout.getChildCount() == 0) {
            addRaceButtons();
        }
    }

    private void addRaceButtons() {
        // 1から12までのボタンを動的に生成
        for (int i = 1; i <= 12; i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(i));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int raceId = Integer.parseInt(button.getText().toString());
                    Intent intent = new Intent(RaceActivity.this, PredictionActivity.class);
                    intent.putExtra("venue_id", venueId);
                    intent.putExtra("race_id", raceId);
                    startActivity(intent);
                }
            });
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
            button.setLayoutParams(params);
            gridLayout.addView(button);
        }
    }
}
