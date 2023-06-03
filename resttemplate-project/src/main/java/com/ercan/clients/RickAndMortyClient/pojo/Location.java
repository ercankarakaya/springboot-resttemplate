package com.ercan.clients.RickAndMortyClient.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
//@JsonIgnoreProperties(value = {"id"})
public class Location {

    private int id;
    private String name;
    private String url;

}
