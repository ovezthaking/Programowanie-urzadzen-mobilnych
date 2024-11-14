package com.example.lista2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lista2.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            usersList = savedInstanceState.getParcelableArrayList("usersList");
        } else {
            usersList = populateUsersList();
        }
    }

    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("usersList", new ArrayList<>(usersList));
    }

    protected List<User> populateUsersList() {
        return new ArrayList<>(List.of(
                new User("admin", "admin"),
                new User("megazord", "megazord2137"),
                new User("maciek", "maciejson"),
                new User("konto4", "h2115"),
                new User("konto5", "y654")
        ));
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public boolean addUser(User user) {
        String password = user.getPassword();
        if (password == null || password.isEmpty() || password.isBlank()) return false;

        String name = user.getName();
        if (name == null || name.isEmpty() || name.isBlank()) return false;

        User foundSameName = usersList.stream()
                .filter(found -> found.getName().equals(name))
                .findFirst().orElse(null);
        if (foundSameName != null) return false;

        usersList.add(user);

        return true;
    }
}