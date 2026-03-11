package com.example.dailymoodjournal;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MoodSelection extends AppCompatActivity {

    ImageView ivHappy = findViewById(R.id.ivHappy)
    final String[] selectedMood = {""};

ivHappy.setOnClickListener(v -> {
        selectedMood[0] = "Happy";
        // Optional: Add a border or highlight to ivHappy here
        ivHappy.setBackgroundColor(Color.LTGRAY);
    });

    Button btnSave = findViewById(R.id.btnSaveMood);
btnSave.setOnClickListener(v -> {
        String note = etMoodNote.getText().toString();
        String date = etDate.getText().toString();
        // Save to Database or SharedPrefs
        Toast.makeText(this, "Saved: " + selectedMood[0], Toast.LENGTH_SHORT).show();
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mood_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Date), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}