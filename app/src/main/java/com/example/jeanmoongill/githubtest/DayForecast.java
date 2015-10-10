package com.example.jeanmoongill.githubtest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jeanmoongill on 2015. 10. 10..
 */
public class DayForecast {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    public Weather weather = new Weather();
    public ForecastTemp foreastTemp = new ForecastTemp();
    public long timestamp;

    public class ForecastTemp {
        public float day;
        public float min;
        public float max;
        public float night;
        public float eve;
        public float morning;
    }

    public String getStringDate(){
        return sdf.format(new Date(timestamp));
    }
}
