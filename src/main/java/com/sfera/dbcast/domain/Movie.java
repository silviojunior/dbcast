package com.sfera.dbcast.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subtitle;
    private String releaseDate;
    private String direction;
    private Double budget;

    @ManyToMany(mappedBy = "movies")
    private List<Character> characters = new ArrayList<>();

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, String subtitle, String releaseDate, String direction, Double budget) {
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

    public List<Character> getCharacters() { return characters; }

    public void setCharacters(List<Character> characters) { this.characters = characters; }

    public List<Actor> getActors() { return actors; }

    public void setActors(List<Actor> actors) { this.actors = actors; }
}
