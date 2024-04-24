package com.ma.wpb.weatherInformationService.wis.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeatherServiceTest {

    private WeatherService objWeatherService;

    @BeforeEach
    public void setup()
    {
        objWeatherService = new WeatherService();
    }

    @Test
    void testscaleConversion()
    {
        Assertions.assertThat(objWeatherService.tempratureConversion(32,'f','c')).isEqualTo(0);
    }



   @Test
    void test2scaleConversion()
    {
        Assertions.assertThat(objWeatherService.tempratureConversion(0,'c','f')).isEqualTo(32);
    }

    @Test
    void test3scaleConversion()
    {
        Assertions.assertThat(objWeatherService.tempratureConversion(0,'f','c')).isEqualTo(-17.77777777777778);
    }
}
