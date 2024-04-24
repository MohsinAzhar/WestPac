package com.ma.wpb.weatherInformationService.wis.controller;

import com.ma.wpb.weatherInformationService.wis.dao.WeatherRepository;
import com.ma.wpb.weatherInformationService.wis.model.Weather;
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
    WeatherRepository weatherRepository;

    @PostMapping("addWeatherInfo")
    public boolean addWeather(@RequestBody Weather weatherInfo)
    {
        weatherRepository.save(weatherInfo);
        return true;
    }

    @PostMapping("addAllWeatherInfo")
    public boolean addWeathers(@RequestBody ArrayList<Weather> listWeather)
    {
        weatherRepository.saveAll(listWeather);
        return true;
    }

    @GetMapping("getAllWeatherInfo")
    public List<Weather> getAllWeathers()
    {
        return weatherRepository.findAll();
    }

    /*public List<Weather> getWeatherByCity(@RequestBody Weather weatherInfo)
    {
        return weatherRepository.findBycity(weatherInfo.getCity());
    }*/


}
