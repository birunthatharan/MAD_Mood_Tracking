package com.example.mad_project.Project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mood_journal.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT UNIQUE," +
                "password TEXT)");

        db.execSQL("CREATE TABLE moods (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER," +
                "mood TEXT," +
                "note TEXT," +
                "date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS moods");
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    // Register
    public long registerUser(String name, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("password", password);
        return db.insert("users", null, cv);
    }

    // Login
    public long loginUser(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT id FROM users WHERE email=? AND password=?",
                new String[]{email, password}
        );

        if (c.moveToFirst()) {
            long id = c.getLong(0);
            c.close();
            return id;
        }
        c.close();
        return -1;
    }

    // Add Mood
    public long addMood(long userId, String mood, String note, String date) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_id", userId);
        cv.put("mood", mood);
        cv.put("note", note);
        cv.put("date", date);
        return db.insert("moods", null, cv);
    }

    // Get Moods
    public Cursor getMoods(long userId) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(
                "SELECT id, mood, note, date FROM moods WHERE user_id=? ORDER BY id DESC",
                new String[]{String.valueOf(userId)}
        );
    }

    // Update Mood
    public int updateMood(long moodId, long userId, String mood, String note) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("mood", mood);
        cv.put("note", note);

        return db.update(
                "moods",
                cv,
                "id=? AND user_id=?",
                new String[]{String.valueOf(moodId), String.valueOf(userId)}
        );
    }

    // Delete Mood
    public int deleteMood(long moodId, long userId) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(
                "moods",
                "id=? AND user_id=?",
                new String[]{String.valueOf(moodId), String.valueOf(userId)}
        );
    }
}