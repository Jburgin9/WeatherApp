package org.quietlip.classexercises.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.quietlip.classexercises.R;
import org.quietlip.classexercises.controller.WeatherAdapter;
import org.quietlip.classexercises.model.AerisWeatherResponse;
import org.quietlip.classexercises.network.RetrofitSingleton;
import org.quietlip.classexercises.network.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: called");
        recyclerView = findViewById(R.id.weather_recycler_view);

        RetrofitSingleton.newInstance().create(WeatherService.class)
                .getWeather()
                .enqueue(new Callback<AerisWeatherResponse>() {
                    @Override
                    public void onResponse(Call<AerisWeatherResponse> call, Response<AerisWeatherResponse> response) {
                        Log.d(TAG, "onResponse: was called " + response.body().getResponse());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerView.setAdapter(new WeatherAdapter(response.body().getResponse().get(0).getPeriods()));
                    }

                    @Override
                    public void onFailure(Call<AerisWeatherResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: called");

                    }
                });
    }
}
