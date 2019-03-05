package org.quietlip.classexercises.network;

import org.quietlip.classexercises.model.AerisWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherService {

    @GET("forecasts/11101?client_id=ZbpsWkxvlM0BMY4Ii5j7X&client_secret=EQvpuiNXBiyXS263xp23qRDwyp831qD15VnKK7rP")
    Call<AerisWeatherResponse> getWeather();
}
