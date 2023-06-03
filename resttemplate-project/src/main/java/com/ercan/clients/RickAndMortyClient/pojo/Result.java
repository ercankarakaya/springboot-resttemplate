package com.ercan.clients.RickAndMortyClient.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Result {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    //@JsonIgnoreProperties(value = {"name"})
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private Date created;
}
