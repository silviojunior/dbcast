package com.sfera.dbcast.resources;

import com.sfera.dbcast.domain.Character;
import com.sfera.dbcast.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> uploadImage(@RequestPart("character") String personagem, @RequestPart("image") MultipartFile imagem) throws IOException{

        characterService.save(personagem, imagem);

        return ResponseEntity.noContent().build();

    }

    @GetMapping()
    public ResponseEntity<List<Character>> findAll() {

        return ResponseEntity.ok().body(characterService.findAll());
    }

    @GetMapping(value = "/movieCharacters/{movieId}")
    public ResponseEntity<List<Character>> getMovieCharacters(@PathVariable Long movieId){

        return ResponseEntity.ok().body(characterService.getMovieCharacters(movieId));
    }

    @GetMapping(value = "/byName/{name}")
    public ResponseEntity<List<Character>> getMoviesByTitle(@PathVariable String name){
        return ResponseEntity.ok().body(characterService.getCharactersByName(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Character> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(characterService.findById(id));
    }
/*
    @PostMapping
    public ResponseEntity<Void> saveCharacter(@RequestBody Character character) {

        character.setId(null);
        characterService.save(character);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Character character) {

        character.setId(id);
        characterService.update(character);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {

        characterService.delete(id);
        return ResponseEntity.noContent().build();
    }*/

}
