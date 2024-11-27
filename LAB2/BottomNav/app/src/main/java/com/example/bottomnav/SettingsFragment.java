package com.example.bottomnav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bottomnav.databinding.SettingsFragmentBinding;

public class SettingsFragment extends Fragment {

    private SettingsFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = SettingsFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }
}