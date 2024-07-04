package com.Task51N6.weather.controller;

import com.Task51N6.weather.model.Weather;
import com.Task51N6.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping
    public Iterable<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Weather> findById(@PathVariable int id) {
        return weatherRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Weather> save(@RequestBody Weather weather) {
        return  weatherRepository.findById(weather.getId()).isPresent()
                ? new ResponseEntity(weatherRepository.findById(weather.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(weatherRepository.save(weather), HttpStatus.CREATED);
    }

    @GetMapping("/{lat}/{lon}")
    public Optional<Weather> findByLocation(@PathVariable int lat, @PathVariable int lon) {
        Iterable<Weather> tempWeather = weatherRepository.findAll();
        Optional<Weather> findWeather = Optional.empty();

        for (Weather i : tempWeather) {
            if ((i.getLat() == lat)&&(i.getLon() == lon)) {
                findWeather = Optional.ofNullable(i);
                break;
            }
        }

        return findWeather;
    }

}
