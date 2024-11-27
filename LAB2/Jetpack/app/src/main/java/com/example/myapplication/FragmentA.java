package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.myapplication.databinding.FragmentaBinding;

public class FragmentA extends Fragment {

    private FragmentaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentaBinding.inflate(inflater);

        binding.fabA.setOnClickListener(view -> {
//            NavDirections action = FragmentADirections.actionFragmentAToFragmentB();
//            Navigation.findNavController(requireView()).navigate(action);

            Bundle args = new Bundle();
            args.putInt("key", 5);
            Navigation.findNavController(requireView()).navigate(R.id.fragmentB, args);
        });

        return binding.getRoot();
    }
}