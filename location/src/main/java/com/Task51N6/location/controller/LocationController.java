package com.Task51N6.location.controller;

import com.Task51N6.location.model.Location;
import com.Task51N6.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @GetMapping
    public Iterable<Location> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable int id) {
        return  repository.findById(id);
    }

    @GetMapping("/locationName/{locationName}")
    public Optional<Location> findByLocation(@PathVariable String locationName) {

        Iterable<Location> allLocation = repository.findAll();
        Optional<Location> findLocation = Optional.empty();

        for (Location i : allLocation) {
            if (i.getLocation().equals(locationName)) {
                findLocation = Optional.ofNullable(i);
                break;
            }
        }

        return findLocation;
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        return repository.findById(location.getId()).isPresent()
                ? new ResponseEntity(repository.findById(location.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(repository.save(location), HttpStatus.CREATED);
    }
}
