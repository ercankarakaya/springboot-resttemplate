package com.ercan.clients.RickAndMortyClient.controller;

import com.ercan.clients.RickAndMortyClient.pojo.Location;
import com.ercan.clients.RickAndMortyClient.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable int id){
        Location location = locationService.getById(id);
        return ResponseEntity.ok(location);
    }

}
