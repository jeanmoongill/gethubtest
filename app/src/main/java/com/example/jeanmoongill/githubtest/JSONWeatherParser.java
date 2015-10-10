package com.example.jeanmoongill.githubtest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jeanmoongill on 2015. 10. 10..
 */
public class JSONWeatherParser {

    public static WeatherForecast getForecastWeather(String data) throws JSONException{

        WeatherForecast forecast = new WeatherForecast();

        JSONObject jobj = new JSONObject(data);

        JSONArray jArr = jobj.getJSONArray("list");

        for(int i = 0; i < jArr.length(); i++){

            JSONObject jDayForecast = jArr.getJSONObject(i);
            // Now we have the json object so we can extract the day
            DayForecast df = new DayForecast();
            // we retrieve the timestamp
            df.timestamp = jDayForecast.getLong("dt");
            //Temp is an Object
            JSONObject jTempObj = jDayForecast.getJSONObject("temp");

            df.foreastTemp.day = (float)jTempObj.getDouble("day");
            df.foreastTemp.min = (float)jTempObj.getDouble("min");
            df.foreastTemp.max = (float)jTempObj.getDouble("max");
            df.foreastTemp.night = (float)jTempObj.getDouble("night");
            df.foreastTemp.eve = (float)jTempObj.getDouble("eve");
            df.foreastTemp.morning = (float)jTempObj.getDouble("morning");

            //Pressure & Humidity
            df.weather.currentCondition.setPressure((float) jDayForecast.getDouble("pressure"));
            df.weather.currentCondition.setHumidity((float) jDayForecast.getDouble("humidity"));

            // and now the weather
            JSONArray jWeatherArr = jDayForecast.getJSONArray("weather");
            JSONObject jWeatherObj = jWeatherArr.getJSONObject(0);
            df.weather.currentCondition.setWeatherId(getInt("id",jWeatherObj));
            df.weather.currentCondition.setDescr(getString("description",jWeatherObj));
            df.weather.currentCondion.setCondion(getString("main",jWeatherObj));
            df.weather.currentCondtion.setIcon(getString("icon",jWeatherObj));

            forecast.addForecast(df);
        }

        return forecast;

    }



}
