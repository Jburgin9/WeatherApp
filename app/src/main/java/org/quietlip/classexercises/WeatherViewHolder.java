package org.quietlip.classexercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.quietlip.classexercises.model.PeriodsResponse;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private TextView testView, test2, test3;
    private ImageView testImage;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);

        testView = itemView.findViewById(R.id.test);
        test2 = itemView.findViewById(R.id.test2);
        test3 = itemView.findViewById(R.id.test3);
        testImage = itemView.findViewById(R.id.imageView);
    }

    public void onBind(PeriodsResponse p){
//        if (p.getMaxTempF() < 50){
//            testImage.setImageResource(R.drawable.freezingrain);
//        }
//        testView.setText(p.getDateTimeISO());
//        test2.setText(p.getMaxTempF());
//        test3.setText(p.getMinTempF());
    }
}
