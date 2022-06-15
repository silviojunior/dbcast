package com.sfera.dbcast.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfera.dbcast.domain.Character;
import com.sfera.dbcast.domain.ImageUtils;
import com.sfera.dbcast.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character findById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public void save(String jsonCharacter, MultipartFile image) throws IOException{
        Character character = characterFromJson(jsonCharacter);

        if(image != null){
            saveCharacterImage(character, image);
        }

        characterRepository.save(character);
    }


    public Character characterFromJson(String jsonCharacter){

        Character character = new Character();

        try{
            ObjectMapper om = new ObjectMapper();
            character = om.readValue(jsonCharacter, Character.class);
        }catch (IOException err){
            System.out.printf("Error", err.toString());
        }

        return character;
    }


    public List<Character> getMovieCharacters(Long movieId) {
        return characterRepository.findAllByMovies_Id(movieId);
    }


    public List<Character> getCharactersByName(String name) {
        return characterRepository.findByNameContainsIgnoreCaseOrAlsoKnownAsContainsIgnoreCase(name, name);
    }


    public void update(String jsonCharacter, MultipartFile image) throws IOException{
        Character character = characterFromJson(jsonCharacter);

        if(image != null){
            saveCharacterImage(character, image);
        }

        Character newChar = find(character.getId());
        updateData(character, newChar);

        characterRepository.save(newChar);
    }

    private void saveCharacterImage(Character character, MultipartFile image) throws IOException{

        String treatedCharacterName = character.getName().replaceAll("\\s+", "");
        String imageName = ImageUtils.getImageName(image,treatedCharacterName);

        ImageUtils.storeImageStaticFolder(imageName, image);
        ImageUtils.storeImageTargetFolder(imageName, image);

        character.setPathToImage(ImageUtils.IMAGE_LOCATION_URL + imageName);
    }

    private void updateData(Character character, Character newCharacter) {
        newCharacter.setName(character.getName());
        newCharacter.setAlsoKnownAs(character.getAlsoKnownAs());
        newCharacter.setType(character.getType());
        newCharacter.setDescription(character.getDescription());
        newCharacter.setPathToImage(character.getPathToImage() != null ? character.getPathToImage() : newCharacter.getPathToImage());
    }

    public void delete(Long id) {
        Character character = find(id);
        String fileName = character.getPathToImage().substring(ImageUtils.IMAGE_LOCATION_URL.length(), character.getPathToImage().length());

        try {
            characterRepository.delete(character);
            ImageUtils.deleteImage(fileName);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public Character find(Long id) {
        Optional<Character> character = characterRepository.findById(id);

        return character.orElse(null);
    }
}
