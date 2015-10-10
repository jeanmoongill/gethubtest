package com.example.jeanmoongill.githubtest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by jeanmoongill on 2015. 10. 10..
 */
public class DayForecastFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dayforecast_fragment, container, false);

        TextView tempView = (TextView) v.findViewById(R.id.tempForecast);
        TextView descView = (TextView) v.findViewById(R.id.skydescForecast);
        tempView.setText((int)(dayForecast.forecastTemp.min - 275.15) + "-" + (int) (dayForecast.forecastTemp.max - 275.15));
        descView.setText(dayForecast.weather.currentCondition.getDescr());
        iconWeather = (ImageView) v.findViewById(R.id.forCondIcon);
        JSONIconWeatherTask task = new JSONIconWeatherTask();
        task.execute(new String[]{dayForecast.weather.currentCondition.getIcon()});

        return v;
}
