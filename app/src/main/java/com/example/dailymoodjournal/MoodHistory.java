package com.example.dailymoodjournal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MoodHistory extends AppCompatActivity {

    ListView listView;

    String tutorials[]
            ={"24th of March - Happy ", "25th of March - Happy ", "26th of March - Sad "};

    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button btnAddMood = findViewById(R.id.btnAddMood);
            btnAddMood.setOnClickListener(v -> {
                // Logic to go to Mood Selection screen
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mood_history);
        listView = findViewById(R.id.myListView);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tutorials);
        listView.setAdapter(arr);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Date), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}