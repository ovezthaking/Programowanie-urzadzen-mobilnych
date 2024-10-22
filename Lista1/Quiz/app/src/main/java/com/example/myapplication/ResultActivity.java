
package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView wynik = findViewById(R.id.wynik);
        int score = getIntent().getIntExtra("score", 0);
        wynik.setText("Zdobyłeś " + score + " pkt");
    }
}
