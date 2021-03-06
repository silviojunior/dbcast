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
    public ResponseEntity<Void> save(@RequestPart("movie") String jsonFilme, @RequestPart("image") MultipartFile imagem) throws IOException {
        movieService.save(jsonFilme, imagem);

        return ResponseEntity.noContent().build();

    }

    @GetMapping()
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok().body(movieService.findAll());
    }

    @GetMapping(value = "/filmography/{characterId}")
    public ResponseEntity<List<Movie>> getFilmography(@PathVariable Long characterId) {
        return ResponseEntity.ok().body(movieService.getFilmography(characterId));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(movieService.findById(id));
    }

    @GetMapping(value = "/byTitle/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        return ResponseEntity.ok().body(movieService.getMoviesByTitle(title));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> update(@RequestPart("movie") String jsonFilme, @RequestPart(value = "image", required = false) MultipartFile imagem) throws IOException{
        movieService.update(jsonFilme, imagem);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {

        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
