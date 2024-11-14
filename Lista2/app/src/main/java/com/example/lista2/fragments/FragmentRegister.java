package com.example.lista2.fragments;

import android.os.Bundle;
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
import com.example.lista2.databinding.FragmentRegisterBinding;
import com.example.lista2.model.User;

public class FragmentRegister extends Fragment {
    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater);

        binding.registerButton.setOnClickListener(view -> {
            String login = binding.loginInput.getText().toString();
            if (login.isEmpty() || login.isBlank()) return;

            String password = binding.passwordInput.getText().toString();
            if (password.isEmpty() || password.isBlank()) return;

            String password2 = binding.passwordInput2.getText().toString();
            if (password2.isEmpty() || password2.isBlank()) return;
            if (!password.equals(password2)) return;

            MainActivity mainActivity = (MainActivity) getActivity();
            if (mainActivity == null) return;

            if (mainActivity.addUser(new User(login, password))) {
                Bundle args = new Bundle();
                args.putString("name", login);
                Navigation.findNavController(requireView()).navigate(R.id.fragmentWelcome, args);
            }
        });

        return binding.getRoot();
    }
}
