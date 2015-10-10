package com.example.jeanmoongill.githubtest;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jeanmoongill on 2015. 10. 10..
 */
public class DailyForecastPageAdapter extends FragmentPagerAdapter {

    private int numDays;
    private FragmentManager fm;
    private WeatherForecast forecast;
    private final static SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MM");

    public DailyForecastPageAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Date d = new Date();
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        gc.add(GregorianCalendar.DAY_OF_MONTH, position);

        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        DayForecast dayForecast = (DayForecast)forecast.getForecast(num);
        DayForecastFragment f = new DayForecastFragment();
        f.setForecast(dayForecast);
        return f;
    }

    @Override
    public int getCount() {
        return numDays;
    }
}
