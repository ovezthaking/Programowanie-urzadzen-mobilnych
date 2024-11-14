package com.example.lista2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.lista2.databinding.FragmentHomeBinding;

public class FragmentHome extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);

        binding.loginButton.setOnClickListener(view -> {
            NavDirections action = FragmentHomeDirections.actionFragmentHomeToFragmentLogin();
            Navigation.findNavController(requireView()).navigate(action);
        });

        binding.registerButton.setOnClickListener(view -> {
            NavDirections action = FragmentHomeDirections.actionFragmentHomeToFragmentRegister();
            Navigation.findNavController(requireView()).navigate(action);
        });

        return binding.getRoot();
    }
}
