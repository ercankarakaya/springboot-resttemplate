package com.ercan.clients.RickAndMortyClient.controller;

import com.ercan.clients.RickAndMortyClient.pojo.Character;
import com.ercan.clients.RickAndMortyClient.service.CharacterService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/all")
    public ResponseEntity<Character> getAllCharacters(){
        Character character = characterService.getAllCharacter();
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Character> getCharacterByPage(@RequestParam("page") int pageNum){
        Character character = characterService.getCharacterByPage(pageNum);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    /*
    @GetMapping("/by-page/{num}")
    public ResponseEntity<Character> getCharacterByPage(@PathVariable("num") int pageNum){
        Character character = characterService.getCharacterByPage(pageNum);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }
    */

     /*
    @GetMapping("/filtered")
    public MappingJacksonValue getAll(){
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("info");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("characterFilter",simpleBeanPropertyFilter);

        Character characters = characterService.getAllCharacter();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(characters);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
   */
}
