package com.interview.questions.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.interview.questions.views.RequestView;
import com.interview.questions.views.User;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRequest {

    private RequestView requestView;
    private Activity activity;

    public NetworkRequest(RequestView requestView, Activity activity) {
        this.requestView = requestView;
        this.activity = activity;
    }

    public void registrationRequest(User user) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        JsonObject paramObject = new JsonObject();
        paramObject.addProperty("name", user.getName());
        paramObject.addProperty("surname", user.getSurname());
        paramObject.addProperty("email", user.getEmail());
        paramObject.addProperty("password", user.getPassword());
        paramObject.addProperty("firebase_id", "1222");
        paramObject.addProperty("dateOfBirth", user.getDateOfBirth());

        Log.v("registrationRequest", "obj: " + paramObject.toString());

        Call<ResponseBody> call = service.register(paramObject);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        String res = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    requestView.onRegistrationSuccessResponse();
                } else { requestView.onRegistrationFailResponse("");
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                requestView.onRegistrationFailResponse(t.getMessage());
            }
        });
    }

}
