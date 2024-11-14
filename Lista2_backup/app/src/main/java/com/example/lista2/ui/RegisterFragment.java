package com.example.lista2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.lista2.model.User;

import java.util.List;

public class RegisterFragment extends Fragment {
    private List<User> userList; // Initialize or get from ViewModel if used

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        Button registerButton = view.findViewById(R.id.button_register);
        registerButton.setOnClickListener(v -> {
            EditText usernameInput = view.findViewById(R.id.input_username);
            EditText passwordInput = view.findViewById(R.id.input_password);
            EditText passwordInput = view.findViewById(R.id.input_password2);
            // Create a new user and add to list
            String username = usernameInput.getText().toString();
            if(input_password != input_password2){

            }
            else {
                String password = passwordInput.getText().toString();
                userList.add(new User(username, password));

                // Navigate to login screen
                Navigation.findNavController(v).navigate(R.id.action_register_to_login);
            }
        });

        return view;
    }
}

