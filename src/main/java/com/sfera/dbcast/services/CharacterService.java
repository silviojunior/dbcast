package com.sfera.dbcast.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfera.dbcast.domain.Character;
import com.sfera.dbcast.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private static final String BASE_URL = "http://localhost:8080/img/";
    private static final String TARGET_STATIC_FOLDER_URL = "target/classes/static/";
    private static final String STATIC_FOLDER_URL = "src/main/resources/static/";

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
            final String fileExtension = Optional.ofNullable(image.getOriginalFilename())
                    .flatMap(CharacterService::getFileExtension)
                    .orElse("");

            String charName = character.getName().replaceAll("\\s+", "");
            String fileName = charName + "." + fileExtension;

            character.setPathToImage(BASE_URL + fileName);

            storeImage(TARGET_STATIC_FOLDER_URL,fileName,image);
            storeImage(STATIC_FOLDER_URL,fileName,image);
        }

        characterRepository.save(character);
    }

    public void storeImage(String pathName, String fileName, MultipartFile file) throws IOException{

        String fileLocation = new File(pathName).getPath() + "/" + fileName;

        try(InputStream in = file.getInputStream()){
            try(OutputStream out = new FileOutputStream(fileLocation)){
                copy(in, out);
            }
        }
    }

    public void deleteCharacterImage(Character character){
        String fileName = character.getPathToImage().substring(BASE_URL.length(), character.getPathToImage().length());

        Path staticFolderPath = Paths.get(STATIC_FOLDER_URL + fileName);
        Path targetFolderPath = Paths.get(TARGET_STATIC_FOLDER_URL + fileName);
        try {
            Files.delete(staticFolderPath);
            Files.delete(targetFolderPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void copy(InputStream source, OutputStream target) throws IOException {
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) > 0) {
            target.write(buf, 0, length);
        }
    }

    private static Optional<String> getFileExtension(String fileName) {
        final int indexOfLastDot = fileName.lastIndexOf('.');

        if (indexOfLastDot == -1) {
            return Optional.empty();
        } else {
            return Optional.of(fileName.substring(indexOfLastDot + 1));
        }
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
            final String fileExtension = Optional.ofNullable(image.getOriginalFilename())
                    .flatMap(CharacterService::getFileExtension)
                    .orElse("");

            String charName = character.getName().replaceAll("\\s+", "");
            String fileName = charName + "." + fileExtension;

            storeImage(TARGET_STATIC_FOLDER_URL,fileName,image);
            storeImage(STATIC_FOLDER_URL,fileName,image);

            character.setPathToImage(BASE_URL + fileName);
        }

        Character newChar = find(character.getId());
        updateData(character, newChar);

        characterRepository.save(newChar);
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

        try {
            characterRepository.delete(character);
            deleteCharacterImage(character);
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
