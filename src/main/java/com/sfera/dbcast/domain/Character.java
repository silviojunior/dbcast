package com.sfera.dbcast.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_character")
public class Character implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String alsoKnownAs;
    private String type;
    private String description;
    private String pathToImage;

    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies = new HashSet<>();

    public Character() {
    }

    public Character(String name, String alsoKnownAs, String type, String description, String pathToImage) {
        this.name = name;
        this.alsoKnownAs = alsoKnownAs;
        this.type = type;
        this.description = description;
        this.pathToImage = pathToImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlsoKnownAs() { return alsoKnownAs; }

    public void setAlsoKnownAs(String alsoKnownAs) { this.alsoKnownAs = alsoKnownAs; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public Set<Movie> getMovies() { return movies; }

    public void setMovies(Set<Movie> movies) { this.movies = movies; }

}
