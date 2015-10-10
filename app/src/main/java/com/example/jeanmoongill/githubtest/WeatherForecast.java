package com.example.jeanmoongill.githubtest;


import java.util.List;
import java.util.ArrayList;

/**
 * Created by jeanmoongill on 2015. 10. 10..
 */
public class WeatherForecast {

    private List<DayForecast> daysForecast = new ArrayList<DayForecast>();

    public void addForecast(DayForecast forecast){
        daysForecast.add(forecast);
    }

    public DayForecast getForecast(int dayNum){
        return daysForecast.get(dayNum);
    }

}
