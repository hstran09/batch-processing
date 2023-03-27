package com.example.batchprocessing.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String lastName;
    private String firstName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstNameOrNull() {
        return this.firstName == null ? "" : this.firstName;
    }

    public String getLastNameOrNull() {
        return this.lastName == null ? "" : this.lastName;
    }

    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }
}
