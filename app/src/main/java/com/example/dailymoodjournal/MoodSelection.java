package com.example.dailymoodjournal;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MoodSelection extends AppCompatActivity {

    ImageView imageView, imageView2, imageView4, imageView5, imageView6, imageView7;
    EditText editTextDate, editTextText;
    Button button4, button5;

    String selectedMood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_selection);

        // Connect UI components
        editTextDate = findViewById(R.id.editTextDate);
        editTextText = findViewById(R.id.editTextText);

        button4 = findViewById(R.id.button4); // Save Mood
        button5 = findViewById(R.id.button5); // Edit Mood

        imageView = findViewById(R.id.imageView);     // Happy
        imageView2 = findViewById(R.id.imageView2);   // Excited
        imageView4 = findViewById(R.id.imageView4);   // Love
        imageView5 = findViewById(R.id.imageView5);   // Sad
        imageView6 = findViewById(R.id.imageView6);   // Angry
        imageView7 = findViewById(R.id.imageView7);   // Sick

        // Mood selection
        imageView.setOnClickListener(v -> {
            resetMoodSelection();
            selectedMood = "Happy";
            imageView.setBackgroundColor(Color.LTGRAY);
        });

        imageView2.setOnClickListener(v -> {
            resetMoodSelection();
            selectedMood = "Excited";
            imageView2.setBackgroundColor(Color.LTGRAY);
        });

        imageView4.setOnClickListener(v -> {
            resetMoodSelection();
            selectedMood = "Love";
            imageView4.setBackgroundColor(Color.LTGRAY);
        });

        imageView5.setOnClickListener(v -> {
            resetMoodSelection();
            selectedMood = "Sad";
            imageView5.setBackgroundColor(Color.LTGRAY);
        });

        imageView6.setOnClickListener(v -> {
            resetMoodSelection();
            selectedMood = "Angry";
            imageView6.setBackgroundColor(Color.LTGRAY);
        });

        imageView7.setOnClickListener(v -> {
            resetMoodSelection();
            selectedMood = "Sick";
            imageView7.setBackgroundColor(Color.LTGRAY);
        });

        // Save mood button
        button4.setOnClickListener(v -> {
            String date = editTextDate.getText().toString().trim();
            String note = editTextText.getText().toString().trim();

            if (selectedMood.isEmpty()) {
                Toast.makeText(MoodSelection.this, "Please select a mood", Toast.LENGTH_SHORT).show();
                return;
            }

            if (date.isEmpty()) {
                editTextDate.setError("Enter date");
                return;
            }

            if (note.isEmpty()) {
                editTextText.setError("Enter note");
                return;
            }

            Toast.makeText(
                    MoodSelection.this,
                    "Mood Saved\nMood: " + selectedMood + "\nDate: " + date + "\nNote: " + note,
                    Toast.LENGTH_LONG
            ).show();
        });

        // Edit mood button
        button5.setOnClickListener(v -> {
            editTextText.requestFocus();
            Toast.makeText(MoodSelection.this, "You can edit the mood note now", Toast.LENGTH_SHORT).show();
        });
    }

    private void resetMoodSelection() {
        imageView.setBackgroundColor(Color.TRANSPARENT);
        imageView2.setBackgroundColor(Color.TRANSPARENT);
        imageView4.setBackgroundColor(Color.TRANSPARENT);
        imageView5.setBackgroundColor(Color.TRANSPARENT);
        imageView6.setBackgroundColor(Color.TRANSPARENT);
        imageView7.setBackgroundColor(Color.TRANSPARENT);
    }
}