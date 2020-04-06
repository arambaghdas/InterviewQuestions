package com.interview.questions.model;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GetDataService {

    @POST(".")
    Call<ResponseBody> register(@Body JsonObject loginObject);
}