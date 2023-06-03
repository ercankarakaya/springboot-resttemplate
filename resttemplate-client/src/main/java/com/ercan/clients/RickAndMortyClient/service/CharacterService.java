package com.ercan.clients.RickAndMortyClient.service;

import com.ercan.clients.RickAndMortyClient.pojo.Character;

public interface CharacterService {

    Character getAllCharacter();

    Character getCharacterByPage(int pageNum);
}
