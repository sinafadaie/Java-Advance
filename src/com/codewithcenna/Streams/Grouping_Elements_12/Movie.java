package com.codewithcenna.Streams.Grouping_Elements_12;

public class Movie implements Comparable<Movie> {
    private String title;
    private int likes;
    private Genre genre;        //Genre is Enum

    public Movie(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public int compareTo(Movie other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return this.title;
    }

    public Genre getGenre() {
        return genre;
    }
}
