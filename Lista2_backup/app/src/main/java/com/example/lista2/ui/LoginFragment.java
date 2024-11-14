package com.example.lista2.ui;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lista2.model.User;

import java.util.List;

public class LoginFragment extends Fragment {
    private List<User> userList; // Initialize or get from ViewModel if used

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = view.findViewById(R.id.button_login);
        loginButton.setOnClickListener(v -> {
            EditText usernameInput = view.findViewById(R.id.input_username);
            EditText passwordInput = view.findViewById(R.id.input_password);

            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();

            // Check if user exists
            for (User user : userList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    // Navigate to welcome screen
                    Navigation.findNavController(v).navigate(R.id.action_login_to_welcome);
                    return;
                }
            }
            // Show error if user not found
            Toast.makeText(getContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}

