package com.example.lab3recyclerviewbasics;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3recyclerviewbasics.databinding.WordListItemBinding;

public class WordListViewHolder extends RecyclerView.ViewHolder {
    private final WordListItemBinding binding;
    public WordListViewHolder(WordListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }

    public void bind(String item){
        binding.singleWord.setText(item);

    }

}