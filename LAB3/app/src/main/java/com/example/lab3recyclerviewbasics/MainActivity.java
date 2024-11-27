package com.example.lab3recyclerviewbasics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lab3recyclerviewbasics.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> wordList = new ArrayList<>();
    private ActivityMainBinding binding; // Deklaracja zmiennej binding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicjalizacja View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Wypełnienie listy
        for (int i = 0; i < 30; i++) {
            wordList.add("Word " + i);
        }

        // Ustawienie adaptera i layout managera
        binding.recyclerView.setAdapter(new WordListAdapter(wordList));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
