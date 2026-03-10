package com.example.mad_project.Project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mood_journal.db";
    private static final int DB_VERSION = 2;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "password TEXT NOT NULL)");

        db.execSQL("CREATE TABLE moods (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER NOT NULL," +
                "mood TEXT NOT NULL," +
                "note TEXT," +
                "date TEXT NOT NULL," +
                "FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS moods");
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public long registerUser(String name, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("password", hashPassword(password));
        return db.insert("users", null, cv);
    }

    public long loginUser(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT id FROM users WHERE email=? AND password=?",
                new String[]{email, hashPassword(password)}
        );

        if (c.moveToFirst()) {
            long id = c.getLong(0);
            c.close();
            return id;
        }

        c.close();
        return -1;
    }

    public long addMood(long userId, String mood, String note, String date) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_id", userId);
        cv.put("mood", mood);
        cv.put("note", note);
        cv.put("date", date);
        return db.insert("moods", null, cv);
    }

    public Cursor getMoods(long userId) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(
                "SELECT id, mood, note, date FROM moods WHERE user_id=? ORDER BY id DESC",
                new String[]{String.valueOf(userId)}
        );
    }

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

    public int deleteMood(long moodId, long userId) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(
                "moods",
                "id=? AND user_id=?",
                new String[]{String.valueOf(moodId), String.valueOf(userId)}
        );
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password;
        }
    }
}