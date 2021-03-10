package com.example.retrofitwithmvvm;

import com.example.retrofitwithmvvm.model.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("users")
    Call<Users> getUserData(@Query("page") int page_no, @Query("limit") int limit);
}
