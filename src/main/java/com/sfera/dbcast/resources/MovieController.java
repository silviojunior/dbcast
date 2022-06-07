package com.sfera.dbcast.resources;

import com.sfera.dbcast.domain.Movie;
import com.sfera.dbcast.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> uploadImage(@RequestPart("movie") String personagem, @RequestPart("image") MultipartFile imagem) throws IOException{

        movieService.save(personagem, imagem);

        return ResponseEntity.noContent().build();

    }

    @GetMapping()
    public ResponseEntity<List<Movie>> findAll() {

        return ResponseEntity.ok().body(movieService.findAll());
    }

    /*

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(movieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveMovie(@RequestBody Movie movie) {

        movie.setId(null);
        movieService.save(movie);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Movie movie) {

        movie.setId(id);
        movieService.update(movie);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {

        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }*/

}
