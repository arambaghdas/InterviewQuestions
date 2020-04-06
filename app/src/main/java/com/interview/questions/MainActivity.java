package com.interview.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.interview.questions.databinding.ActivityMainBinding;
import com.interview.questions.presenter.RegisterPresenter;
import com.interview.questions.views.RegisterView;
import com.interview.questions.views.User;

public class MainActivity extends AppCompatActivity implements RegisterView {

    private RegisterPresenter registerPresenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = new User();
        user.setName("Aram");
        user.setSurname("Baghdasaryan");
        user.setEmail("arambaghdas@gmail.com");
        user.setPassword("Test1234");
        user.setDateOfBirth("01-26-1989");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(user);
        registerPresenter = new RegisterPresenter(this, this);
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void registerOnClick(View view) {
        registerPresenter.performRegistration(binding.getUser());
    }
}
