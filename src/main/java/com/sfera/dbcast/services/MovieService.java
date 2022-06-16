package com.sfera.dbcast.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfera.dbcast.domain.ImageUtils;
import com.sfera.dbcast.domain.Movie;
import com.sfera.dbcast.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void save(String jsonMovie, MultipartFile image) throws IOException {
        Movie movie = movieFromJson(jsonMovie);

        if(image != null){
            saveMovieImage(movie, image);
        }

        movieRepository.save(movie);
    }

    private void saveMovieImage(Movie movie, MultipartFile image) throws IOException{
        String treatedCharacterName = movie.getTitle().replaceAll("\\s+", "");
        String imageName = ImageUtils.getImageName(image, treatedCharacterName);

        ImageUtils.storeImageStaticFolder(imageName, image);
        ImageUtils.storeImageTargetFolder(imageName, image);

        movie.setPathToImage(ImageUtils.IMAGE_LOCATION_URL + imageName);
    }

    public Movie movieFromJson(String jsonMovie) {
        Movie movie = new Movie();

        try {
            movie = new ObjectMapper().readerFor(Movie.class).readValue(jsonMovie);
        } catch (IOException err) {
            System.out.printf("Error", err.toString());
        }

        return movie;
    }

    public List<Movie> getFilmography(Long characterId) {
        return movieRepository.findAllByCharacters_Id(characterId);
    }

    public List<Movie> getMoviesByTitle(String title) {
        return movieRepository.findByTitleContainsIgnoreCase(title);
    }

    public void update(String jsonMovie, MultipartFile image) throws IOException{
        Movie movie = movieFromJson(jsonMovie);

        if(image != null){
            saveMovieImage(movie, image);
        }

        Movie newMovie = find(movie.getId());
        updateData(movie, newMovie);

        movieRepository.save(newMovie);
    }

    private void updateData(Movie movie, Movie newMovie) {
        newMovie.setTitle(movie.getTitle());
        newMovie.setSubtitle(movie.getSubtitle());
        newMovie.setBudget(movie.getBudget());
        newMovie.setDirection(movie.getDirection());
        newMovie.setReleaseDate(movie.getReleaseDate());
        newMovie.setPathToImage(movie.getPathToImage() != null ? movie.getPathToImage() : newMovie.getPathToImage());
        newMovie.setCharacters(movie.getCharacters());
    }

    public void delete(Long id) {
        Movie movie = find(id);
        String fileName = movie.getPathToImage().substring(ImageUtils.IMAGE_LOCATION_URL.length(), movie.getPathToImage().length());

        try {
            movieRepository.delete(movie);
            ImageUtils.deleteImage(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public Movie find(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        return movie.orElse(null);
    }
}
