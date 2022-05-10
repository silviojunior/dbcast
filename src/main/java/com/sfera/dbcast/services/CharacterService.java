package com.sfera.dbcast.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfera.dbcast.domain.Character;
import com.sfera.dbcast.repositories.CharacterRepository;
import com.sfera.dbcast.resources.CharacterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private static final String BASE_URL = "http://localhost:8080/img/";
    private static final String TARGET_STATIC_FOLDER_URL = "target/classes/static/";
    private static final String STATIC_FOLDER_URL = "src/main/resources/static/";

    @Autowired
    private CharacterRepository characterRepository;

/*    public List<Character> findAll() {

        return characterRepository.findAll();
    }

    public Character findById(Long id) {

        return characterRepository.findById(id).orElse(null);
    }*/

    public void save(String jsonCharacter, MultipartFile image) throws IOException{

        final String fileExtension = Optional.ofNullable(image.getOriginalFilename())
                .flatMap(CharacterService::getFileExtension)
                .orElse("");

        Character character = characterFromJson(jsonCharacter);
        String charName = character.getName().replaceAll("\\s+", "");
        String fileName = charName + "." + fileExtension;

        storeImage(TARGET_STATIC_FOLDER_URL,fileName,image);
        storeImage(STATIC_FOLDER_URL,fileName,image);
        character.setPathToImage(BASE_URL+fileName);
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

/*    public void update(Character character) {

        Character newCharacter = find(character.getId());
        updateData(character, newCharacter);

        characterRepository.save(newCharacter);
    }

    private void updateData(Character character, Character newCharacter) {
        newCharacter.setName(character.getName());
        newCharacter.setHometown(character.getHometown());
        newCharacter.setBirthdate(character.getBirthdate());
        newCharacter.setDeathdate(character.getDeathdate());
        newCharacter.setAge(character.getAge());
        newCharacter.setMaritalStatus(character.getMaritalStatus());
    }

    public void delete(Long id) {

        Character character = find(id);

        try {
            characterRepository.delete(character);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public Character find(Long id) {

        Optional<Character> character = characterRepository.findById(id);

        return character.orElse(null);
    }*/
}
