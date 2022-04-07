package com.sfera.dbcast.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_actor")
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String hometown;
    private String birthdate;
    private String deathdate;
    private Integer age;
    private String maritalStatus; //Enum

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tb_actors_characters",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<Character> characters = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tb_movies_actors",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();

    public Actor() {
    }

    public Actor(String name, String hometown, String birthdate, String deathdate, Integer age, String maritalStatus) {
        this.name = name;
        this.hometown = hometown;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.age = age;
        this.maritalStatus = maritalStatus;
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

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(String deathdate) {
        this.deathdate = deathdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<Character> getCharacters() { return characters; }

    public void setCharacters(List<Character> characters) { this.characters = characters; }

    public List<Movie> getMovies() { return movies; }

    public void setMovies(List<Movie> movies) { this.movies = movies; }
}
