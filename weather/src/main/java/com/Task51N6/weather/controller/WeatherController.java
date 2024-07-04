package com.Task51N6.weather.controller;

import com.Task51N6.weather.model.Root;
import com.Task51N6.weather.model.Weather;
import com.Task51N6.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Optional;

@RestController
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${appid}")
    String appId;

    @GetMapping("/weather")
    public Root getWeather() {
        return  restTemplate.getForObject("https://api.openweathermap.org/data/3.0/onecall?lat=54.1838&lon=45.1749&units=metric&appid=" + appId, Root.class);
    }

}
