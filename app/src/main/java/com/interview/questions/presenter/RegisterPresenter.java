package com.interview.questions.presenter;

import android.app.Activity;

import com.interview.questions.model.NetworkRequest;
import com.interview.questions.views.RegisterView;
import com.interview.questions.views.RequestView;
import com.interview.questions.views.User;

public class RegisterPresenter implements RequestView {

    private Activity activity;
    private RegisterView baseView;
    private NetworkRequest networkRequest;

    public RegisterPresenter(Activity activity, RegisterView baseView) {
        this.activity = activity;
        this.baseView = baseView;
        this.networkRequest = new NetworkRequest(this, activity);
    }

    public void performRegistration(User user) {
        networkRequest.registrationRequest(user);
    }

    @Override
    public void onRegistrationSuccessResponse() {
        baseView.showToastMessage("Success");
    }

    @Override
    public void onRegistrationFailResponse(String message) {
        baseView.showToastMessage(message);
    }
}
