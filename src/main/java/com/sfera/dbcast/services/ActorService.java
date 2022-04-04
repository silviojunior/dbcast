package com.sfera.dbcast.services;

import com.sfera.dbcast.domain.Actor;
import com.sfera.dbcast.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> findAll() {

        return actorRepository.findAll();
    }

    public Actor findById(Long id) {

        return actorRepository.findById(id).orElse(null);
    }

    public void insert(Actor actor) {
        actorRepository.save(actor);
    }

    public void update(Actor actor) {

        Actor newActor = find(actor.getId());
        updateData(actor, newActor);

        actorRepository.save(newActor);
    }

    private void updateData(Actor actor, Actor newActor) {
        newActor.setName(actor.getName());
        newActor.setHometown(actor.getHometown());
        newActor.setBirthdate(actor.getBirthdate());
        newActor.setDeathdate(actor.getDeathdate());
        newActor.setAge(actor.getAge());
        newActor.setMaritalStatus(actor.getMaritalStatus());
    }

    public void delete(Long id) {

        Actor actor = find(id);

        try {
            actorRepository.delete(actor);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public Actor find(Long id) {

        Optional<Actor> actor = actorRepository.findById(id);

        return actor.orElse(null);
    }
}
