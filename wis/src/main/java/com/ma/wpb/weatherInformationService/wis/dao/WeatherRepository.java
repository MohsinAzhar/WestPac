package com.ma.wpb.weatherInformationService.wis.dao;

import com.ma.wpb.weatherInformationService.wis.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, String> {

    List<Weather> findByCity(String city);

    List<Weather> findByDate(Date date);
}
