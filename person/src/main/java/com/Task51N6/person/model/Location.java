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
public class Location {

    @Id @GeneratedValue
    private int id;

    @NonNull private String location;
    @NonNull private int lat;
    @NonNull private int lon;

    public Location(@NonNull String location, @NonNull int lat, @NonNull int lon) {
        this.location = location;
        this.lat = lat;
        this.lon = lon;
    }

}
