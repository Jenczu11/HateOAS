package com.atos.rest.model;

import org.springframework.hateoas.ResourceSupport;

public class Student extends ResourceSupport {
    int indexNumber;
    String firstName;
    String lastName;
    String departament;

    public Student(int indexNumber, String firstName, String lastName, String departament) {
        super();
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
}
