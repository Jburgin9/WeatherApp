package org.quietlip.classexercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import org.quietlip.classexercises.model.PeriodsResponse;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private TextView timeStamp, maxTemp, minTemp;
    private ImageView weatherIcon;
    private Switch celsiusSwitch;
    private double highCelsius = 0;
    private double lowCelsius = 0;
    private String high = "High ";
    private PeriodsResponse periodsResponse;


    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);

        timeStamp = itemView.findViewById(R.id.time_stamp_text_view);
        maxTemp = itemView.findViewById(R.id.max_temp_text_view);
        minTemp = itemView.findViewById(R.id.min_temp_text_view);
        weatherIcon = itemView.findViewById(R.id.imageView);
        celsiusSwitch = itemView.findViewById(R.id.celsius_switch);
        periodsResponse = new PeriodsResponse();

    }

    public void onBind(final PeriodsResponse p) {
        timeStamp.setText(p.getDateTimeISO());
        maxTemp.setText(p.getMaxTempF());
        minTemp.setText(p.getMinTempF());
        celsiusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    highCelsius = (Integer.parseInt(p.getMaxTempF()) - 32) / 1.8;
                    lowCelsius = (Integer.parseInt(p.getMinTempF()) - 32) / 1.8;

                    maxTemp.setText(String.valueOf(highCelsius));
                    minTemp.setText(String.valueOf(lowCelsius));
                } else if (isChecked == false){
                    maxTemp.setText(p.getMaxTempF());
                    minTemp.setText(p.getMinTempF());
                }
            }
        });

        if (Integer.parseInt(p.getMaxTempF()) > 10 && Integer.parseInt(p.getMaxTempF()) < 20){
            weatherIcon.setImageResource(R.drawable.freezingrain);
        } else if (Integer.parseInt(p.getMaxTempF()) > 21 && Integer.parseInt(p.getMaxTempF()) < 34){
            weatherIcon.setImageResource(R.drawable.wind);
        } else if (Integer.parseInt(p.getMaxTempF()) > 34){
            weatherIcon.setImageResource(R.drawable.sunny);
        }

    }
}


