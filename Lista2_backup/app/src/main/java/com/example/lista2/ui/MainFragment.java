package com.example.lista2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        view.findViewById(R.id.button_login).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_main_to_login));
        view.findViewById(R.id.button_register).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_main_to_register));
        return view;
    }
}

