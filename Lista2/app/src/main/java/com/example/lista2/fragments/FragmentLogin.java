package com.example.lista2.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.lista2.MainActivity;
import com.example.lista2.R;
import com.example.lista2.databinding.FragmentLoginBinding;
import com.example.lista2.model.User;

import java.util.ArrayList;
import java.util.List;

public class FragmentLogin extends Fragment {
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater);

        MainActivity activity = (MainActivity) getActivity();

        List<User> users = activity != null ? activity.getUsersList() : new ArrayList<>();

        binding.loginButton.setOnClickListener(view -> {
            if (users.isEmpty()) return;

            String login = binding.loginInput.getText().toString();
            if (login.isEmpty() || login.isBlank()) return;


            String password = binding.passwordInput.getText().toString();
            if (password.isEmpty() || password.isBlank()) return;

            User foundUser = users.stream()
                    .filter(user -> user.getName().equals(login) && user.getPassword().equals(password))
                    .findFirst().orElse(null);
            if (foundUser == null) return;

            Bundle args = new Bundle();
            args.putString("name", login);

            Navigation.findNavController(requireView()).navigate(R.id.fragmentWelcome, args);
        });

        binding.registerButton.setOnClickListener(view -> {
            NavDirections action = FragmentLoginDirections.actionFragmentLoginToFragmentRegister();
            Navigation.findNavController(requireView()).navigate(action);
        });

        return binding.getRoot();
    }
}
