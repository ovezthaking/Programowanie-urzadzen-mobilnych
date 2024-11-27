package com.example.bottomnav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bottomnav.databinding.FirstFragmentBinding;

public class FirstFragment extends Fragment {

    private FirstFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FirstFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }
}
