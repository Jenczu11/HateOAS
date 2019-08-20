package com.atos.rest.model;

import org.springframework.hateoas.ResourceSupport;

public class Year extends ResourceSupport {
    int year;
    String description;

    public Year(int year, String description) {
        super();
        this.year = year;
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
