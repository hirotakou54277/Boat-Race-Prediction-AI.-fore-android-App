package com.example.boatraceprediction;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PredictionActivity extends AppCompatActivity {
    private TextView resultText;
    private Interpreter tflite;
    private int venueId;
    private int raceId;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        resultText = findViewById(R.id.result_text);
        dbHelper = new DatabaseHelper(this);

        venueId = getIntent().getIntExtra("venue_id", 0);
        raceId = getIntent().getIntExtra("race_id", 0);

        try {
            tflite = new Interpreter(loadModelFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new ScrapeTask().execute();
    }

    private MappedByteBuffer loadModelFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(getAssets().openFd("model.tflite").getFileDescriptor());
        FileChannel fileChannel = fileInputStream.getChannel();
        long startOffset = getAssets().openFd("model.tflite").getStartOffset();
        long declaredLength = getAssets().openFd("model.tflite").getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    private class ScrapeTask extends AsyncTask<Void, Void, String[]> {
        @Override
        protected String[] doInBackground(Void... voids) {
            try {
                String today = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
                String url = "https://www.boatrace.jp/owpc/pc/race/racelist?rno=" + raceId + "&jcd=" + venueId + "&hd=" + today;

                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("div.is-fs18.is-fBold");
                String[] names = new String[6];
                for (int i = 0; i < elements.size(); i++) {
                    names[i] = elements.get(i).text().replace(" ", "");
                }
                return names;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] names) {
            if (names != null) {
                predict(names);
            } else {
                resultText.setText("スクレイピングに失敗しました。");
            }
        }
    }

    private void predict(String[] names) {
        // 特徴量の抽出
        float[] features = extractFeatures(names);

        // 予測の実行
        float[][] output = new float[1][1];  // 予測結果のサイズに応じて調整
        tflite.run(features, output);

        // 結果の表示
        resultText.setText("予測結果: " + output[0][0]);
    }

    private float[] extractFeatures(String[] names) {
        float[] features = new float[60]; // 各選手ごとに10個の特徴量を持つと仮定
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        for (int i = 0; i < names.length; i++) {
            Cursor cursor = dbHelper.getPlayerData(names[i]);
            if (cursor.moveToFirst()) {
                for (int j = 0; j < 10; j++) { // 各選手の特徴量を取得
                    features[i * 10 + j] = cursor.getFloat(j + 1); // 0番目の列は名前のため、1から開始
                }
            } else {
                // デフォルト値（0または平均値など）を使用
                for (int j = 0; j < 10; j++) {
                    features[i * 10 + j] = 0;
                }
            }
            cursor.close();
        }
        return features;
    }
}
