package com.Task51N6.weather.repository;

import com.Task51N6.weather.model.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Integer> {
}
