package com.ma.wpb.weatherInformationService.wis.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeathersByDateRequest {

    private Date date;
    private char unit;

}
