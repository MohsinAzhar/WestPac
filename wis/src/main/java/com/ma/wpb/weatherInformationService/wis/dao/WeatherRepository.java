package com.ma.wpb.weatherInformationService.wis.dao;

import com.ma.wpb.weatherInformationService.wis.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, String> {
}
