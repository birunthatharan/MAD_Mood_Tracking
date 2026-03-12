package com.example.mad_project.Project;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_project.R;   // ⭐ ADD THIS LINE

import java.util.ArrayList;

public class MoodHistory extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        listView = findViewById(R.id.myListView);

        // Empty list (no sample data)
        ArrayList<String> moodList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                moodList
        );

        listView.setAdapter(adapter);
    }
}