package com.example.boatraceprediction;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "boat_race_data.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 初回実行時にデータベースが存在しない場合に呼ばれる
        // テーブルの作成などを行う
        String CREATE_PLAYERS_TABLE = "CREATE TABLE players (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "名前漢字 TEXT, " +
                "勝率 REAL, " +
                "複勝率 REAL, " +
                "平均スタートタイミング REAL, " +
                "1コース1着回数 INTEGER, " +
                "1コース2着回数 INTEGER, " +
                "1コース3着回数 INTEGER, " +
                "2コース1着回数 INTEGER, " +
                "2コース2着回数 INTEGER, " +
                "2コース3着回数 INTEGER, " +
                "3コース1着回数 INTEGER, " +
                "3コース2着回数 INTEGER, " +
                "3コース3着回数 INTEGER, " +
                "4コース1着回数 INTEGER, " +
                "4コース2着回数 INTEGER, " +
                "4コース3着回数 INTEGER, " +
                "5コース1着回数 INTEGER, " +
                "5コース2着回数 INTEGER, " +
                "5コース3着回数 INTEGER, " +
                "6コース1着回数 INTEGER, " +
                "6コース2着回数 INTEGER, " +
                "6コース3着回数 INTEGER" +
                ")";
        db.execSQL(CREATE_PLAYERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // データベースのスキーマが変更された場合に呼ばれる
        db.execSQL("DROP TABLE IF EXISTS players");
        onCreate(db);
    }

    // 名前を指定して選手データを取得するメソッド
    public Cursor getPlayerData(String playerName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM players WHERE 名前漢字=?";
        return db.rawQuery(query, new String[]{playerName});
    }
}
