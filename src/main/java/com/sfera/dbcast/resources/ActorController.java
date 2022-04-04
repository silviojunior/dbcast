package com.sfera.dbcast.resources;

import com.sfera.dbcast.domain.Actor;
import com.sfera.dbcast.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping()
    public ResponseEntity<List<Actor>> findAll() {

        return ResponseEntity.ok().body(actorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(actorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> insertActor(@RequestBody Actor actor) {

        actor.setId(null);
        actorService.insert(actor);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Actor actor) {

        actor.setId(id);
        actorService.update(actor);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {

        actorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
