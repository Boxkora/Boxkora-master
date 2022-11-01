package com.example.cinemaapp.model;

import java.io.Serializable;
import java.util.Objects;

public class Film implements Serializable {

    private final String title;
    private final String genre;
    private final String description;
    private final double rating;
    private final int imagePath;

    public Film(String title, String genre, String description, double rating, int imagePath) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setFavorite() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
