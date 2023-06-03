package com.ercan.clients.RickAndMortyClient.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Character {

    private Info info;
    private List<Result> results;
}
