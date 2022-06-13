package com.sfera.dbcast.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfera.dbcast.domain.Movie;
import com.sfera.dbcast.repositories.MovieRepository;
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
public class MovieService {

    private static final String BASE_URL = "http://localhost:8080/img/";
    private static final String TARGET_STATIC_FOLDER_URL = "target/classes/static/";
    private static final String STATIC_FOLDER_URL = "src/main/resources/static/";

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {

        return movieRepository.findAll();
    }

    public Movie findById(Long id) {

        return movieRepository.findById(id).orElse(null);
    }

    public void save(String jsonMovie, MultipartFile image) throws IOException {

        final String fileExtension = Optional.ofNullable(image.getOriginalFilename()).flatMap(MovieService::getFileExtension).orElse("");

        Movie movie = movieFromJson(jsonMovie);

        String charName = movie.getTitle().replaceAll("\\s+", "");
        String fileName = charName + "." + fileExtension;

        storeImage(TARGET_STATIC_FOLDER_URL, fileName, image);
        storeImage(STATIC_FOLDER_URL, fileName, image);
        movie.setPathToImage(BASE_URL + fileName);
        movieRepository.save(movie);
    }

    public void storeImage(String pathName, String fileName, MultipartFile file) throws IOException {

        String fileLocation = new File(pathName).getPath() + "/" + fileName;

        try (InputStream in = file.getInputStream()) {
            try (OutputStream out = new FileOutputStream(fileLocation)) {
                copy(in, out);
            }
        }
    }

    public void deleteMovieImage(Movie movie){
        String fileName = movie.getPathToImage().substring(BASE_URL.length(), movie.getPathToImage().length());

        Path staticFolderPath = Paths.get(STATIC_FOLDER_URL + fileName);
        Path targetFolderPath = Paths.get(TARGET_STATIC_FOLDER_URL + fileName);
        try {
            Files.delete(staticFolderPath);
            Files.delete(targetFolderPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public List<Movie> getFilmography(Long characterId) {

        return movieRepository.findAllByCharacters_Id(characterId);
    }

    public List<Movie> getMoviesByTitle(String title) {
        return movieRepository.findByTitleContainsIgnoreCase(title);
    }

    public void update(Movie movie) {

        Movie newMovie = find(movie.getId());
        updateData(movie, newMovie);

        movieRepository.save(newMovie);
    }

    private void updateData(Movie movie, Movie newMovie) {
        newMovie.setTitle(movie.getTitle());
        newMovie.setSubtitle(movie.getSubtitle());
        newMovie.setBudget(movie.getBudget());
        newMovie.setPathToImage(movie.getPathToImage());
        newMovie.setDirection(movie.getDirection());
        newMovie.setReleaseDate(movie.getReleaseDate());
    }

    public void delete(Long id) {

        Movie movie = find(id);

        try {
            movieRepository.delete(movie);
            deleteMovieImage(movie);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public Movie find(Long id) {

        Optional<Movie> movie = movieRepository.findById(id);

        return movie.orElse(null);
    }
}
