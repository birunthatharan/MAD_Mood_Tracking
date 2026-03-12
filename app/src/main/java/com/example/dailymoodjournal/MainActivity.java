package com.example.dailymoodjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAddMood, btnViewHistory, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddMood = findViewById(R.id.button);
        btnViewHistory = findViewById(R.id.button2);
        btnLogout = findViewById(R.id.button3);

        btnAddMood.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MoodSelection.class);
            startActivity(intent);
        });

        btnViewHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MoodHistory.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            finish();
        });
    }

}