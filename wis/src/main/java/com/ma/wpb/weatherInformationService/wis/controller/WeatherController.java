package com.ma.wpb.weatherInformationService.wis.controller;

import com.ma.wpb.weatherInformationService.wis.dto.WeatherByCityRequest;
import com.ma.wpb.weatherInformationService.wis.dto.WeathersByDateRequest;
import com.ma.wpb.weatherInformationService.wis.model.Weather;
import com.ma.wpb.weatherInformationService.wis.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @PostMapping("addWeatherInfo")
    public boolean addWeather(@RequestBody Weather weatherInfo)
    {
        weatherService.save(weatherInfo);
        return true;
    }

    @PostMapping("addAllWeatherInfo")
    public boolean addWeathers(@RequestBody ArrayList<Weather> listWeather)
    {
        weatherService.saveAll(listWeather);
        return true;
    }

    @GetMapping("getAllWeatherInfo")
    public List<Weather> getAllWeathers()
    {
        return weatherService.findAll();
    }

    @PostMapping("getWeatherByCity")
    public List<Weather> getWeatherByCity(@RequestBody WeatherByCityRequest weatherByCityInfo)
    {
        return weatherService.findByCity(weatherByCityInfo.getCity(),weatherByCityInfo.getUnit());
    }
    @PostMapping("getAllWeathersByDate")
    public List<Weather> getAllWeathersByDate(@RequestBody WeathersByDateRequest weatherByDateInfo)
    {
        return weatherService.findByDate(weatherByDateInfo.getDate(), weatherByDateInfo.getUnit());
    }


}
