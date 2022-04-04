package com.sfera.dbcast.services;

import com.sfera.dbcast.domain.Cast;
import com.sfera.dbcast.repositories.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastService {

    @Autowired
    private CastRepository castRepository;

    public List<Cast> findAll() {

        return castRepository.findAll();
    }

    public Cast findById(Long id) {

        return castRepository.findById(id).orElse(null);
    }

    public void insert(Cast cast) {
        castRepository.save(cast);
    }

    public void update(Cast cast) {

        Cast newCast = find(cast.getId());
        updateData(cast, newCast);

        castRepository.save(newCast);
    }

    private void updateData(Cast cast, Cast newCast){
        newCast.setName(cast.getName());
        newCast.setHometown(cast.getHometown());
        newCast.setBirthdate(cast.getBirthdate());
        newCast.setDeathdate(cast.getDeathdate());
        newCast.setAge(cast.getAge());
        newCast.setMaritalStatus(cast.getMaritalStatus());
    }

    public void delete(Long id) {

        Cast cast = find(id);

        try{
            castRepository.delete(cast);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public Cast find(Long id) {

        Optional<Cast> cast = castRepository.findById(id);

        return cast.orElse(null);
    }
}
