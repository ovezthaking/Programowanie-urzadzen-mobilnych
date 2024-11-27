package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.myapplication.databinding.FragmentbBinding;

public class FragmentB extends Fragment {

    private FragmentbBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentbBinding.inflate(inflater);

        binding.textView.setText(String.valueOf(
                getArguments() != null ? getArguments().getInt("key") : 0
        ));
        binding.fabB.setOnClickListener(v -> {
            NavDirections action = FragmentBDirections.actionFragmentBToFragmentA();
            Navigation.findNavController(requireView()).navigate(action);
        });

        return binding.getRoot();
    }
}