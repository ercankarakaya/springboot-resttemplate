package com.ercan.clients.RickAndMortyClient.service.impl;

import com.ercan.clients.RickAndMortyClient.pojo.Location;
import com.ercan.clients.RickAndMortyClient.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders httpHeaders;

    private String LOCATION_API_URL="https://rickandmortyapi.com/api/location";

    @Override
    public Location getById(int id) {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Location> response = restTemplate.exchange(LOCATION_API_URL+"/"+id, HttpMethod.GET,entity,Location.class);
        return response.getBody();
    }
}
