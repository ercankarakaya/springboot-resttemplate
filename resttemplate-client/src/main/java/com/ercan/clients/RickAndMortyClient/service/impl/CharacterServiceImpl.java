package com.ercan.clients.RickAndMortyClient.service.impl;

import com.ercan.clients.RickAndMortyClient.pojo.Character;
import com.ercan.clients.RickAndMortyClient.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders httpHeaders;

    private String CHARACTER_API_URL="https://rickandmortyapi.com/api/character";

    @Override
    public Character getAllCharacter() {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Character> response = restTemplate.exchange(CHARACTER_API_URL, HttpMethod.GET,entity,Character.class);
        return response.getBody();
    }

    public Character getCharacterByPage(int pageNum){
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Character> response = restTemplate.exchange(CHARACTER_API_URL+"?page="+pageNum,HttpMethod.GET,entity,Character.class);
        return response.getBody();
    }

}
