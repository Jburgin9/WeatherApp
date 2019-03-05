package org.quietlip.classexercises.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "http://api.aerisapi.com/";
    private static Retrofit ourInstance;

    private RetrofitSingleton(){}

    public static Retrofit newInstance(){
        if (ourInstance == null) {
            ourInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return ourInstance;
    }
}
