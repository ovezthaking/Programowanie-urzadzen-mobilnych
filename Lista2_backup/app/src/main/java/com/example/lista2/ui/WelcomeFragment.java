package com.example.lista2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.lista2.model.User;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class WelcomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        Button logoutButton = view.findViewById(R.id.button_logout);
        logoutButton.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_welcome_to_main));

        // Display welcome message
        TextView welcomeText = view.findViewById(R.id.welcome_text);
        welcomeText.setText("Witaj " +  User.getUsername() );

        return view;
    }
}

