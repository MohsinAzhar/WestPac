package com.ma.wpb.weatherInformationService.wis.dto;


import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherByCityRequest {

    @Id
    private String city;
}
