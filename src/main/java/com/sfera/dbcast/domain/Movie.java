package com.sfera.dbcast.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sfera.dbcast.config.CustomListDeserializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pathToImage;
    private String title;
    private String subtitle;
    private String releaseDate;
    private String direction;
    private Double budget;

    @JsonIgnore
    @JsonDeserialize(using = CustomListDeserializer.class)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="tb_movies_characters",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private Set<Character> characters = new HashSet<>();

    public Movie() {
    }

    public Movie(String pathToImage, String title, String subtitle, String releaseDate, String direction, Double budget) {
        this.pathToImage = pathToImage;
        this.title = title;
        this.subtitle = subtitle;
        this.releaseDate = releaseDate;
        this.direction = direction;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathToImage() { return pathToImage; }

    public void setPathToImage(String pathToImage) { this.pathToImage = pathToImage; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Set<Character> getCharacters() { return characters; }

    public void setCharacters(Set<Character> characters) { this.characters = characters; }
}
