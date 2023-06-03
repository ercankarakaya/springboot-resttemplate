package com.ercan.clients.RickAndMortyClient.controller;

import com.ercan.clients.RickAndMortyClient.pojo.Character;
import com.ercan.clients.RickAndMortyClient.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
