package com.example.counterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView showCount;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        showCount = findViewById(R.id.show_count);
        Button increaseButton = findViewById(R.id.increase_button);
        if (showCount != null)
            showCount.setText(String.valueOf(count));

        if (increaseButton != null)
            increaseButton.setOnClickListener(view -> {
                count++;
                showCount.setText(String.valueOf(count));

            });

    }
}

/*
private TextView showCount;
    private int count;
    private Button increaseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCount = findViewById(R.id.show_count);
        increaseButton = findViewById(R.id.increase_button);

        if (showCount != null)
            showCount.setText(String.valueOf(count));

        if (increaseButton != null)
            increaseButton.setOnClickListener(view -> {
                count++;
                showCount.setText(String.valueOf(count));
            });
 */