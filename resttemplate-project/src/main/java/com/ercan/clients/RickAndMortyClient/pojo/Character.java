package com.ercan.clients.RickAndMortyClient.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

import java.util.List;

@Data
//@JsonFilter("characterFilter")
public class Character {

    private Info info;
    private List<Result> results;
}
