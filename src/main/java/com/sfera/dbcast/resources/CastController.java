package com.sfera.dbcast.resources;

import com.sfera.dbcast.domain.Cast;
import com.sfera.dbcast.services.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/cast")
public class CastController {

    @Autowired
    private CastService castService;

    @GetMapping()
    public ResponseEntity<List<Cast>> findAll(){

        return ResponseEntity.ok().body(castService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cast> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(castService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> insertCast(@RequestBody Cast cast){

        cast.setId(null);
        castService.insert(cast);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Cast cast){

        cast.setId(id);
        castService.update(cast);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCast(@PathVariable Long id){

        castService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
