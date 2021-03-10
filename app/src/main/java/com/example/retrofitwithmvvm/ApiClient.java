package com.example.retrofitwithmvvm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://reqres.in/api/";
    private static ApiClient client;
    private static Retrofit retrofit;

    public ApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClient getInstance(){
        if(client==null){
            client = new ApiClient();
        }
        return client;
    }

    public ApiInterface getAPI(){
        return retrofit.create(ApiInterface.class);
    }
}
