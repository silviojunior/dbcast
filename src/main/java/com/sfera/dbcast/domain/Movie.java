package com.sfera.dbcast.domain;

import java.io.Serializable;

public class Movie implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String subtitle;
    private String releaseDate;
    private String direction;
    private Long budget;

    public Movie(){}

    public Movie(Long id, String title, String subtitle, String releaseDate, String direction, Long budget) {
        this.id = id;
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

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}
