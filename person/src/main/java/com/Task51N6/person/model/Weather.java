package com.Task51N6.person.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {

    @Id @GeneratedValue
    private int id;

    @NonNull private int lat;
    @NonNull private int lon;
    @NonNull private int temperature;

    public Weather(@NonNull int lat, @NonNull int lon, @NonNull int temperature) {
        this.lat = lat;
        this.lon = lon;
        this.temperature = temperature;
    }

}
