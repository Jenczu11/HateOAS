package com.atos.rest.model;

import org.springframework.hateoas.ResourceSupport;

public class Subject extends ResourceSupport {
    String name;
    int rating;

    public Subject(String name, int rating) {
        super();
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
