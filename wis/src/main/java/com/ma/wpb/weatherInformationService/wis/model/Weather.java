package com.ma.wpb.weatherInformationService.wis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    private String city;
    private double temp;
    private char unit;
    private String weather;
    private Date date;
}
