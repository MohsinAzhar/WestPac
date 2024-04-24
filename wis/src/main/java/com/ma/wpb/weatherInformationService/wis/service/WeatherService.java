package com.ma.wpb.weatherInformationService.wis.service;

import com.ma.wpb.weatherInformationService.wis.dao.WeatherRepository;
import com.ma.wpb.weatherInformationService.wis.dto.WeatherByCityRequest;
import com.ma.wpb.weatherInformationService.wis.dto.WeathersByDateRequest;
import com.ma.wpb.weatherInformationService.wis.model.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Autowired
    WeatherRepository objWeatherRepository;

    public boolean save(Weather weatherInfo)
    {
        try {
            objWeatherRepository.save(weatherInfo);
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveAll(ArrayList<Weather> listWeather)
    {
        try{
        objWeatherRepository.saveAll(listWeather);
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<Weather> findAll()
    {
        ArrayList<Weather> arrWeathers = new ArrayList<>();
        try
        {
            arrWeathers = (ArrayList<Weather>) objWeatherRepository.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return arrWeathers;
    }

    public List<Weather> findByCity(String city, char desiredUnit)
    {
        try {
        return objWeatherRepository.findByCity(city).stream()
                .map(weather -> Weather.builder()
                        .city(weather.getCity())
                        .temp(tempratureConversion(weather.getTemp(),weather.getUnit(),desiredUnit))
                        .unit(desiredUnit)
                        .date(weather.getDate())
                        .weather(weather.getWeather())
                        .build()).collect(Collectors.toList());
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        return null;

    }
    public List<Weather> findByDate(Date date , char desiredUnit)
    {
        try {

            return objWeatherRepository.findByDate(date).stream()
                    .map(weather -> Weather.builder()
                            .city(weather.getCity())
                            .temp(tempratureConversion(weather.getTemp(),weather.getUnit(),desiredUnit))
                            .unit(desiredUnit)
                            .date(weather.getDate())
                            .weather(weather.getWeather())
                            .build()).collect(Collectors.toList());

        } catch (Exception e)
        {
            e.printStackTrace();

        }
        return null;
    }

    public double tempratureConversion(double temp, char unit, char desitredUnit)
    {
        if(Character.toUpperCase(unit)==Character.toUpperCase(desitredUnit))
        {
            return temp;
        }else
        {
            if(Character.toUpperCase(desitredUnit)=='F')
            {
                return ((temp* 9/5) + 32);
            }else
            {
                return ((temp - 32) * 5/9);
            }
        }
    }
}
