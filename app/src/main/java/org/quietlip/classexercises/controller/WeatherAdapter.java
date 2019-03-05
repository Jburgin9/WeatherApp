package org.quietlip.classexercises.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.quietlip.classexercises.R;
import org.quietlip.classexercises.WeatherViewHolder;
import org.quietlip.classexercises.model.PeriodsResponse;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    private List<PeriodsResponse> periodsResponseList;

    public WeatherAdapter(List<PeriodsResponse> periodsResponseList) {
        this.periodsResponseList = periodsResponseList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
    weatherViewHolder.onBind(periodsResponseList.get(i));
    }

    @Override
    public int getItemCount() {
        return periodsResponseList.size();
    }
}
