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

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Autowired
    WeatherRepository objWeatherRepository;

    public boolean save(Weather weatherInfo)
    {
        objWeatherRepository.save(weatherInfo);
        return true;
    }

    public boolean saveAll(ArrayList<Weather> listWeather)
    {
        objWeatherRepository.saveAll(listWeather);
        return true;
    }
    public List<Weather> findAll()
    {
        return objWeatherRepository.findAll();
    }

    public List<Weather> findByCity(String city)
    {
        return objWeatherRepository.findByCity(city);
    }
    public List<Weather> findByDate(Date date)
    {
        return objWeatherRepository.findByDate(date);
    }
}
