package com.example.lista2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.lista2.databinding.FragmentWelcomeBinding;

public class FragmentWelcome extends Fragment {
    FragmentWelcomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater);

        binding.logoutButton.setOnClickListener(view -> {
            NavDirections action = FragmentWelcomeDirections.actionFragmentWelcomeToFragmentHome();
            Navigation.findNavController(requireView()).navigate(action);
        });

        assert getArguments() != null;
        binding.textView.setText(String.format("Witaj\n%s", getArguments().getString("name")));

        return binding.getRoot();
    }
}
