package com.codewithcenna.Streams.Sorting_6;

public class Movie implements Comparable<Movie> {   //at first, I try to Extend movie to Comparable
    private String title;                           //we can not extend a class to interface
    private int likes;                              //class implement interface
                                                    //class extend class
                                                    //interface extend interface
    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
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
}
