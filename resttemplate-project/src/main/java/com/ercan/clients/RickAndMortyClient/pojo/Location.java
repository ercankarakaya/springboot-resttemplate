package com.ercan.clients.RickAndMortyClient.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
//@JsonIgnoreProperties(value = {"name"})
public class Location {

    private String name;
    private String url;

}
